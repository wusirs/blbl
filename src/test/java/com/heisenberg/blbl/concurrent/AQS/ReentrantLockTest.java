package com.heisenberg.blbl.concurrent.AQS;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {

    //创建锁对象，有个有参构造可以创建公平锁
    static ReentrantLock lock = new ReentrantLock();
    //条件1
    static Condition c1 = lock.newCondition();
    //条件2
    static Condition c2 = lock.newCondition();

    public static void main(String[] args) throws InterruptedException {

        //可打断
        lockInterrupt();

        //可超时
//        timeOutLock();

        //多条件变量
//        conditionTest();

    }

    /**
     * 多条件变量
     */
    public static void conditionTest(){
        new Thread(() -> {
            lock.lock();
            try {
                //进入c1条件的等待
                c1.await();
                System.out.println(Thread.currentThread().getName()+",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t1").start();
        new Thread(() -> {
            lock.lock();
            try {
                //进入c2条件的等待
                c1.await();
                System.out.println(Thread.currentThread().getName()+",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t2").start();

        new Thread(() -> {
            lock.lock();
            try {
                //唤醒c1条件的线程
                c1.signalAll();
                //唤醒c2条件的线程
//                c2.signal();
                System.out.println(Thread.currentThread().getName()+",acquire lock...");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }, "t3").start();


    }

    /**
     * 锁超时
     * @throws InterruptedException
     */
    public static void timeOutLock() throws InterruptedException {

        Thread t1 = new Thread(() -> {
            //尝试获取锁，如果获取锁成功，返回true，否则返回false
            try {
                if (!lock.tryLock(2, TimeUnit.SECONDS)) {
                    System.out.println("t1-获取锁失败");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                System.out.println("t1线程-获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");

        lock.lock();
        System.out.println("主线程获得了锁");
        t1.start();
        try {
            Thread.sleep(3000);
        } finally {
            lock.unlock();
        }
    }

    /**
     * 可打断
     * @throws InterruptedException
     */
    public static void lockInterrupt() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                //开启可中断的锁

                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("等待的过程中被打断");
                return;
            }
            try {
                System.out.println(Thread.currentThread().getName() + ",获得了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        System.out.println("主线程获得了锁");
        t1.start();

        try {
            Thread.sleep(1000);
            t1.interrupt();
            System.out.println("执行打断");
        } finally {
            lock.unlock();
        }
    }



}
