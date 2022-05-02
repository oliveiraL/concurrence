package com.letscode.executorservice;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    private static final ExecutorService threadpool = Executors.newFixedThreadPool(4);
    public static void main(String[] args) throws InterruptedException, ExecutionException {

        NothingTask task = new NothingTask(100L);
        NothingTask task2 = new NothingTask(200L);
        NothingTask task3 = new NothingTask(150L);
        NothingTask task4 = new NothingTask(300L);

        Future<Long> future = threadpool.submit(task);
        Future<Long> future2 = threadpool.submit(task2);
        Future<Long> future3 = threadpool.submit(task3);
        Future<Long> future4 = threadpool.submit(task4);



        System.out.println(future4.get());

        System.out.println("oi");

        System.out.println(future2.get());
        System.out.println(future3.get());
        System.out.println(future.get());


    }

    public String getQualquer() {
        return "";
    }

}

