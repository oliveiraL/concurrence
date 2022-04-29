package com.letscode.executor;

import java.util.concurrent.Executor;

public class ExecutorDemo {
    public static void main(String[] args) {
        Executor executor = new Invoker();
        executor.execute(()->{
            System.out.println("task to be performed");
        });
    }

}