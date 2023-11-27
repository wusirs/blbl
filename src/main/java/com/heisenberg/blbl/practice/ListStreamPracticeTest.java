package com.heisenberg.blbl.practice;

import com.heisenberg.blbl.domain.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ListStreamPracticeTest {
    Logger logger = Logger.getLogger(getClass().getName());

    private static final Map<String, String> person1 = new HashMap<>();

    private static final Map<String, String> person2 = new HashMap<>();

    static {
        person1.put("name", "lisa");
        person1.put("age", "14");

        person2.put("name", "mike");
        person2.put("age", "17");
    }

    @Test
    public void listToMap() {
        List<User> userList = getUserList();

        // List<Object> => Map<String, Object>
        Map<String, User> collect1 = userList.stream().collect(Collectors.toMap(User::getUsername
                , item -> item, (val1, val2) -> val1));
        logger.fine(collect1.toString());

        // List<Object> => Map<String, String>
        Map<String, String> collect2 =
                userList.stream().collect(Collectors.toMap(User::getUsername,
                        User::getPassword, (val1, val2) -> val1));
        logger.info(collect2.toString());

        // List<Object> => Map<String, List>
        Map<String, List<User>> collect3 =
                userList.stream().collect(Collectors.groupingBy(User::getUsername));
        logger.info(collect3.toString());

        // List<Object> => Map<String, List>
        Map<String, List<User>> collect4 =
                userList.stream().collect(Collectors.toMap(User::getUsername,
                        Collections::singletonList, // 等于： item -> Collections.singletonList(item)
                        (val1, val2) -> {
                            List<User> union = new ArrayList<>(val1);
                            union.addAll(val2);
                            return union;
                        }));
        logger.info(collect4.toString());

        List<Map<String, String>> personList = getPersonList();

        // List<Map<String, String>> => Map<String, String>
        Map<String, String> collect5 =
                personList.stream().collect(Collectors.toMap(item -> item.get("name"),
                        item -> item.get("age"), (val1, val2) -> val2));
        logger.info(collect5.toString());

        // List<Map<String, String>> => Map<String, Map<String, String>>
        Map<String, Map<String, String>> collect6 =
                personList.stream().collect(Collectors.toMap(item -> item.get("name"),
                        item -> item, (val1, val2) -> val2));
        logger.info(collect6.toString());
    }

    private static List<User> getUserList() {
        List<User> userList;
        User user1 = new User();
        user1.setUsername("lisa");
        user1.setPassword("abc");
        User user2 = new User();
        user2.setUsername("lisa");
        user2.setPassword("abc");
        User user3 = new User();
        user3.setUsername("mike");
        user3.setPassword("bdf");
        userList = Arrays.asList(user1, user2, user3);
        return userList;
    }

    private static List<Map<String, String>> getPersonList() {
        return Arrays.asList(person1, person2);
    }
}
