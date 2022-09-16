package com.wow.testcode.reflection;

import com.wow.reflectionutils.ReflectionUtils;
import com.wow.remoteutils.SSHClient;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by kisrosen on 17/3/14.
 */
public class ReflectionTester {

    /**
     * Reflection Test Code
     *
     * @param args
     */
    public static void main(String[] args) {
        SSHClient sshClient = new SSHClient();

        // 获取class名称
        System.out.println("01-----获取class名称-----");
        System.out.println(sshClient.getClass().getName());
        System.out.println(sshClient.getClass().getSimpleName());
        System.out.println(sshClient.getClass().getTypeName());

        Class<?> clazz1 = null;
        Class<?> clazz2 = null;
        Class<?> clazz3 = null;

        // 获取对象或者类的Class实例
        try {
            clazz1 = Class.forName(sshClient.getClass().getName());
            clazz2 = sshClient.getClass();
            clazz3 = ReflectionUtils.class;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 获取类的构造函数，用构造函数实例一个对象
        for (Constructor<?> clazz1Cstor : clazz1.getConstructors()) {
            System.out.println(clazz1Cstor.getName());
            try {
                SSHClient client1 = (SSHClient) clazz1.newInstance();
                SSHClient client2 = (SSHClient) clazz1Cstor.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        // 获取类定义的方法、属性
        System.out.println("02-----获取类定义的方法、属性-----");
        try {
            SSHClient client = (SSHClient) clazz1.newInstance();
            Method setHostMethod = clazz1.getDeclaredMethod("setHost", String.class);
            setHostMethod.invoke(client, "111");

            Field field = client.getClass().getDeclaredField("host");
            field.setAccessible(true);
            System.out.println(field.get(client));
            field.set(client,"a new host");
            System.out.println(field.get(client));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

        // 获取类的注解
        System.out.println("03-----获取类使用的注解-----");
        for (Annotation annotation : clazz1.getAnnotations()) {
            System.out.println(annotation.getClass().getName());
            System.out.println(annotation.toString());
            System.out.println(annotation.annotationType());
        }
    }
}
