package com.heisenberg.blbl.test.concurrent;

/**
 * @author Heisenberg
 * @version 1.0
 * @date 2024-07-03 22:23:23
 */
public class ThreadTest {
    private static volatile boolean flag = false;

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            int i = 0;
            while (!flag){ // JIT 会优化这段代码为while(true){i ++} 导致一直循环，volatile关键字确保本条指令不会因编译器的优化而省略
                i++;
            }
            System.out.println(Thread.currentThread().getName() + "while run " + i + " times");
        }).start();

        Thread.sleep(1000);

        new Thread(() -> {
            flag = true;
            System.out.println(Thread.currentThread().getName() + "running");
        }).start();
    }
}
