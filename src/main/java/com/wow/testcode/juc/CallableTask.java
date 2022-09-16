package com.wow.testcode.juc;

import java.util.concurrent.Callable;

/**
 * Created by arthur.hw on 2017/11/9.
 */
public class CallableTask implements Callable {
    @Override
    public Object call() throws Exception {

        // sleep 10 seconds
        Thread.sleep(10000);

        return 10;
    }
}
