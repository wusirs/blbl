package com.heisenberg.blbl.practice;

import com.heisenberg.blbl.domain.User;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@SuppressWarnings("all")
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

    @Test
    public void lambdaTest() {
        // 遍历
        List<String> fruitList = Arrays.asList("banana", "apple", "orange", "pear");
        fruitList.forEach(System.out::println);

        // 排序
        List<String> sortList = fruitList.stream().sorted().collect(Collectors.toList());
        logger.info(String.format("%s", sortList));
        logger.info(fruitList.toString());

        Collections.sort(fruitList, (o1, o2) -> o2.compareTo(o1));
        logger.info(fruitList.toString());

        // 过滤
        List<String> filterList = fruitList.stream().filter(item -> item.startsWith("a")).collect(Collectors.toList());
        logger.info(filterList.toString());

        // map
        List<Integer> singleLength = fruitList.stream().map(String::length).collect(Collectors.toList());
        logger.info(singleLength.toString());

        // 归约
        List<Integer> integerList = Arrays.asList(1, 2, 3, 4, 5);
        int sum = 0;

        Integer reduce = integerList.stream().reduce(0, (a, b) -> a + b);
//        Integer reduce1 = integerList.stream().reduce(0, Integer::sum);
        logger.info(reduce.toString());


        // 分组
        Map<Integer, List<String>> groupFriutMap = fruitList.stream().collect(Collectors.groupingBy(String::length));
        logger.info(groupFriutMap.toString());

        // 判空
        String str = "hello";
        Optional.ofNullable(str).map(String::toUpperCase).ifPresent(System.out::println);
    }


    @Test
    public void lambdaTest1() {
        MyInterface myInterface = new MyInterface() {
            @Override
            public void doSomething(String s) {
                System.out.println(s);
            }
        };

        myInterface.doSomething("hello world");

        MyInterface myInterface1 = s -> System.out.println(s);
//        MyInterface myInterface2 = System.out::println;


        Thread thread = new Thread(() -> System.out.println("hello world"));

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        });



    }
}


interface MyInterface {
    void doSomething(String s);
}