package com.wow.testcode.proxy.cglib;

import com.wow.testcode.proxy.RealSubject;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by kisrosen on 17/3/6.
 */
public class Hacker implements MethodInterceptor {

    public Object getProxy(RealSubject subject) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(subject.getClass());
        enhancer.setCallback(this);

        Object proxyClass = enhancer.create();

        return proxyClass;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

        System.out.println("before the method is invoked");

        methodProxy.invokeSuper(o, objects);

        System.out.println("after the method is invoked");

        return null;
    }
}
