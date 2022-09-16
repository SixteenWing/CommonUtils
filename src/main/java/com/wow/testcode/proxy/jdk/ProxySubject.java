package com.wow.testcode.proxy.jdk;

import com.wow.testcode.proxy.Subject;

/**
 * Created by kisrosen on 17/3/6.
 */
public class ProxySubject implements Subject {

    private Subject proxied = null;

    /**
     * bind the proxied object
     *
     * @param client
     */
    public ProxySubject(Subject client) {
        this.proxied = client;
    }

    @Override
    public void play() {
        // do something before play
        System.out.println("before the client is playing");
        this.proxied.play();
        System.out.println("after the client is playing");
        // do something after play
    }

    @Override
    public void upgrade(Integer level) {
        // do something before upgrade
        System.out.println("before the client is upgrading");
        this.proxied.upgrade(level);
        System.out.println("before the client is upgrading");
        // do something after upgrade
    }

    @Override
    public void rest() {
        // do something before rest
        System.out.println("before the client is resting");
        this.proxied.rest();
        System.out.println("before the client is resting");
        // do something after rest
    }
}
