package com.wow.testcode.juc;

/**
 * Created by arthur.hw on 2017/11/9.
 */
public class RunnableTask implements Runnable {
    @Override
    public void run() {
        // sleep 10seconds
        try {
            Thread.sleep(5000);
            System.out.println(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
