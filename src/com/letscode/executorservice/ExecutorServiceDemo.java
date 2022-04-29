package com.letscode.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);
    public static void main(String args[]) throws InterruptedException,
            ExecutionException {
        NothingTask task = new NothingTask();
        Future<Integer> future = threadpool.submit(task);
        System.out.println(future.get());
    }

}

