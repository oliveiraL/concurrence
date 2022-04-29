package com.letscode.executorservice;

import java.util.concurrent.Callable;

public class NothingTask implements Callable<Integer> {

    @Override
    public Integer call() {

        return 0;
    }

}
