package com.wow.testcode;

import com.wow.testcode.proxy.RealSubject;
import com.wow.testcode.proxy.Subject;
import com.wow.testcode.proxy.cglib.Hacker;
import com.wow.testcode.proxy.jdk.MyInvocationHandler;
import com.wow.testcode.proxy.jdk.ProxySubject;

import java.lang.reflect.Proxy;

/**
 * Created by kisrosen on 17/3/6.
 */
public class TestMain {
    public static void main(String[] args) {
        testJdkDynamicProxy();
    }

    private void testA() {
        ProxySubject proxy = new ProxySubject(new RealSubject());
        proxy.play();
        proxy.rest();
        proxy.upgrade(1);
    }

    private static void testJdkDynamicProxy() {
        Subject subject = new Subject() {
            @Override
            public void play() {

            }

            @Override
            public void upgrade(Integer level) {

            }

            @Override
            public void rest() {

            }
        };

        // 生成InvocationHandler实例
        MyInvocationHandler h = new MyInvocationHandler(subject);

        // 获取被代理对象实现的接口列表
        Class[] interfaces = new Class[]{Subject.class};

        // 获取被代理对象的classloader
        ClassLoader classLoader = subject.getClass().getClassLoader();

        Subject proxy = (Subject) Proxy.newProxyInstance(classLoader, interfaces, h);

        proxy.play();

        proxy.rest();

        proxy.upgrade(1);
    }

    private void testCglibDynamicProxy() {
        RealSubject subject = new RealSubject();

        Hacker hacker = new Hacker();
        RealSubject proxy = (RealSubject) hacker.getProxy(subject);

        proxy.play();
    }
}
