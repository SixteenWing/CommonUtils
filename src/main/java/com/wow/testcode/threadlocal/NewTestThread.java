package com.wow.testcode.threadlocal;

/**
 * Created by arthur.hw on 2017/8/17.
 */
public class NewTestThread implements Runnable {

    private TestThreadLocal seq;

    private TestBean testBean;

    public NewTestThread(TestThreadLocal seq, TestBean testBean) {
        this.seq = seq;

        this.testBean = testBean;
    }

    @Override
    public void run() {
        System.out.println("thread inner--> " + Thread.currentThread().getName() + " --> " + this.seq.getSeq());
        for (int i = 0; i < 3; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread --> " + Thread.currentThread().getName() + " --> seq = "
                    + seq.addSeq().getId());
        }
    }
}
