package com.wow.testcode.threadlocal;

/**
 * Created by arthur.hw on 2017/8/17.
 */
public class TestThreadLocal {
    private ThreadLocal<TestBean> seq = new ThreadLocal<TestBean>() {
        @Override
        protected TestBean initialValue() {
            return new TestBean();
        }
    };

    public TestBean addSeq() {

        System.out.println("thread --> " + Thread.currentThread().getName() + " --> " + seq.get());

        seq.get().setId(seq.get().getId() + 1);

        return seq.get();
    }

    public void setSeq(TestBean testbean) {

        this.seq.set(testbean);
    }

    public TestBean getSeq() {

        return this.seq.get();
    }

    public static void main(String[] args) {

        TestThreadLocal tlocal = new TestThreadLocal();

        TestBean testbean = new TestBean();
        tlocal.setSeq(testbean);
        tlocal.addSeq();

        Thread thread1 = new Thread(new NewTestThread(tlocal, testbean));
        Thread thread2 = new Thread(new NewTestThread(tlocal, testbean));

        thread1.start();
        thread2.start();
    }
}
