package com.wow.testcode.proxy.jdk;

import com.wow.testcode.proxy.Subject;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by kisrosen on 17/3/6.
 */
public class MyInvocationHandler implements InvocationHandler {

    private Subject subject = null;

    public MyInvocationHandler(Subject subject) {
        this.subject = subject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("before the method is invoked");

        if (method.getName().equals("upgrade")) {
            method.invoke(this.subject, args);
        } else {
            method.invoke(this.subject, null);
        }

        System.out.println("after the method is invoked");

        return null;
    }
}
