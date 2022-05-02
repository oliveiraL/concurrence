package com.letscode.executorservice;

import java.util.concurrent.Callable;

public class NothingTask implements Callable<Long> {

    private Long sleep;

    public NothingTask(Long sleep) {
        this.sleep = sleep;
    }

    @Override
    public Long call() throws InterruptedException {
        System.out.println("INIT TASK "+sleep);
        Thread.sleep(sleep);
        System.out.println("TASK" + sleep);
        return sleep;
    }

}
