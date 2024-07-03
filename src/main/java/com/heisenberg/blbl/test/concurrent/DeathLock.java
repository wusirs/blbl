package com.heisenberg.blbl.test.concurrent;

/**
 * 死锁排查：
 * 方法一：
 * jps + jstack -l tid(进程id)
 * 方法二：
 * jdk/bin/jconsole.exe
 * 方法三：
 * jdk/bin/jvisualvm.exe
 * @author Heisenberg
 * @version 1.0
 * @date 2024-07-03 21:49:49
 */
public class DeathLock {
    public static void main(String[] args) {
        Object A = new Object();
        Object B = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (A) {
                System.out.println(Thread.currentThread().getName() + " locked A");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (B){
                    System.out.println(Thread.currentThread().getName() + "locked B");
                    System.out.println(Thread.currentThread().getName() + "操作...");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (B) {
                System.out.println(Thread.currentThread().getName() + " locked B");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

                synchronized (A) {
                    System.out.println(Thread.currentThread().getName() + " locked A");
                    System.out.println(Thread.currentThread().getName() + "操作...");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
