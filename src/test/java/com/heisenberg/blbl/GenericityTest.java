package com.heisenberg.blbl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-03-27 11:47:47
 */
@SuppressWarnings("all")
public class GenericityTest {
    public static void main(String[] args) {
        // 逆变
        List<? super Fruit> list = new ArrayList<Food>();
//        list.add(new Food());       // error
        list.add(new Fruit());
        list.add(new Apple());
        list.add(new RedApple());
        Object object = list.get(0);

        // 逆变
        List<? super Apple> list2 = new ArrayList<Fruit>();
//        list2.add(new Food());          // error
//        list2.add(new Fruit());         // error
        list2.add(new Apple());
        list2.add(new RedApple());
//        list2.add(new Object());        // error

        // 协变
        List<? extends Fruit> list1 = new ArrayList<Apple>();
//        list1.add(new Apple());     // error
//        list1.add(new RedApple());  // error
//        list1.add(new Food());      // error
//        list1.add(new Fruit());     // error
//        list1.add(new Object());    // error
        Fruit fruit = list1.get(0);
    }
}


class Food{}

class Fruit extends Food{}

class Apple extends Fruit{}

class RedApple extends Apple{}

class GreenApple extends Apple{}
