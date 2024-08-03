package com.heisenberg.blbl.test.concurrent;

/**
 * public ThreadPoolExecutor(
 * int corePoolSize, // 核心线程数
 * int maximumPoolSize, // 最大线程数 = 核心线程数 + 非核心线程数
 * int keepAliveTime, // 线程存活时间 - 非核心线程生存时间，生存时间内没有心任务，此线程会被回收
 * TimeUnit unit, // 时间单位 - 非核心线程生存时间单位，如秒、毫秒等
 * BlockingQueue<Runnbable> workQueue, // 当没有空闲核心线程时，新来任务会加入到此队列排队，队列满会创建非核心线程执行任务
 * ThreadFactory threadFactory, // 线程工厂 - 可以定制线程对象的创建，例如设置线程名字、是否是守护线程等
 * RejectedExecutionHandler handler //拒绝策略 - 当所有线程都在繁忙，workQueue也放满时，会触发拒绝策略
 * )
 * @author Heisenberg
 * @version 1.0
 * @date 2024-07-03 22:35:35
 */
public class ThreadPoolTest {

}
