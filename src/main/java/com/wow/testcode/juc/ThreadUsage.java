package com.wow.testcode.juc;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by arthur.hw on 2017/11/9.
 */
public class ThreadUsage {

    public static void main(String[] args) {
        ThreadUsage threadUsage = new ThreadUsage();
        System.out.println(0);
//        threadUsage.executeCallable();
        threadUsage.executeRunnable();
    }

    public void executeCallable(){
        FutureTask<Integer> future = new FutureTask(new CallableTask());
        new Thread(future).start();

        System.out.println(2);

        try {
            Integer ret = future.get();

            System.out.println(ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public void executeRunnable(){
        Thread thread = new Thread(new RunnableTask());
        thread.start();
    }
}
