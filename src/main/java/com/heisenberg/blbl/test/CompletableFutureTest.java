package com.heisenberg.blbl.test;


import org.apache.log4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

    private static final Logger LOGGER =
            Logger.getLogger(CompletableFutureTest.class.getName());

    public static void main(String[] args) {
        thenApplyAsyncTest();
        runAsyncTest();
    }

    public static void runAsyncTest() {
        CompletableFuture<Void> runAsync = CompletableFuture.runAsync(() -> LOGGER.info("running"));

        runAsync.join();
    }

    public static void applyTest() throws ExecutionException, InterruptedException {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("supply Async running");
            return 0;
        });
        completableFuture.join();

        LOGGER.info(completableFuture.get());
    }


    public static void acceptTest() {
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("running 1");
            return 1004;
        }).thenAccept(LOGGER::info);
        completableFuture.join();
    }

    public static void thenApplyAsyncTest() {
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            LOGGER.info("running 1");
            return 122;
        }).thenApplyAsync(t -> {
            LOGGER.info("running 2");
            return 321;
        }).thenApplyAsync(t -> {
            LOGGER.info("running 3");
            return 111;
        });
        completableFuture.join();
    }
}
