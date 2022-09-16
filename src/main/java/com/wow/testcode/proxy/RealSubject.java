package com.wow.testcode.proxy;

/**
 * Created by kisrosen on 17/3/6.
 */
public class RealSubject implements Subject {
    @Override
    public void play() {
        System.out.println("the client is playing");
    }

    @Override
    public void upgrade(Integer level) {
        System.out.println("the client is upgrading");
    }

    @Override
    public void rest() {
        System.out.println("the client is resting");
    }
}
