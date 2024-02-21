package com.heisenberg.blbl.test;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

public class FutureTaskTest {
    private static final ConcurrentMap<Object, Future<String>> taskCache = new ConcurrentHashMap<>();

    private static final Logger LOGGER =  LoggerFactory.getLogger(FutureTaskTest.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("task1: {}", executionTask("task1"));
            LOGGER.info("task2: {}", executionTask("task2"));
        } catch (ExecutionException | InterruptedException e) {
            LOGGER.error("", e);
            Thread.currentThread().interrupt();
        }
    }

    private static  String executionTask(final String taskName)throws ExecutionException, InterruptedException {
        while (true) {
            Future<String> future = taskCache.get(taskName); // 1.1,2.1
            if (future == null) {
                Callable<String> task = () -> taskName;
                FutureTask<String> futureTask = new FutureTask<>(task);
                future = taskCache.putIfAbsent(taskName, futureTask); // 1.3
                if (future == null) {
                    future = futureTask;
                    futureTask.run(); // 1.4执行任务
                }
            }
            try {
                return future.get(); // 1.5,
            } catch (CancellationException e) {
                taskCache.remove(taskName, future);
            }
        }
    }

}
