package com.letscode.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException {
        execute();
    }

    public static void execute() throws InterruptedException {

        System.out.println("Available permit : " + semaphore.availablePermits());
        System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());


        if (semaphore.tryAcquire()) {
            try {
                semaphore.acquire();
                System.out.println("Available permit : " + semaphore.availablePermits());
                System.out.println("Number of threads waiting to acquire: " + semaphore.getQueueLength());
            } finally {

                semaphore.release();
            }
        }else {
            System.out.println(":(");
        }

    }
}
