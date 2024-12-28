package com.heisenberg.blbl;

import java.util.HashSet;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-04-01 16:59:59
 */
public class ATest {
    public static void main(String[] args) {
        HashSet set = new HashSet();
        set.add("Hello");
        set.add("World");
    }

    //局部final变量a,b
    public void test(final int b) {//jdk8在这里做了优化, 不用写,语法糖，但实际上也是有的，也不能修改
        final int a = 10;
        //匿名内部类
        new Thread(){
            public void run() {
                System.out.println(a);
                System.out.println(b);
            };
        }.start();
    }
}


class OutClass {
    private int age = 12;

    public void outPrint(final int x) {
        class InClass {
            public void InPrint() {
                System.out.println(x);
                System.out.println(age);
            }
        }
        new InClass().InPrint();
    }
}