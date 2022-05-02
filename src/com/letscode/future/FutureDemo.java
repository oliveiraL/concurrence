package com.letscode.future;

import java.util.concurrent.*;

public class FutureDemo {
    private static final ExecutorService threadpool = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException,  ExecutionException, TimeoutException {

        FactorialSquareCalculator factorialSquareCalculator = new FactorialSquareCalculator(10);

        System.out.println(factorialSquareCalculator.compute());


//        NothingTask task = new NothingTask();
//        Future<Integer> future = threadpool.submit(task);
//        while (!future.isDone()) {
//            System.out.println("Tarefa não terminada ainda...");
//            Thread.sleep(100L); // espera para tentar novamente
//        }
//        System.out.println("Tarefa finalizada!");
//        Integer result = (Integer) future.get(500, TimeUnit.MILLISECONDS);

//        Integer result = (Integer) future.get();
//        System.out.println(result);

    }

}

