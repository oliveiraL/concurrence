package com.letscode.future;

import java.util.concurrent.Callable;

public class NothingTask implements Callable<Integer> {

    @Override
    public Integer call() throws InterruptedException {
        Thread.sleep(1000L);
        return 0;
    }

}
