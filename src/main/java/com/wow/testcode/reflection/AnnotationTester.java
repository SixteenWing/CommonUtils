package com.wow.testcode.reflection;

import com.wow.remoteutils.SSHClient;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

/**
 * Created by kisrosen on 17/3/14.
 */
public class AnnotationTester {

    public static void main(String[] args) {
        Annotation[] annotations = new Annotation[0];

        annotations = SSHClient.class.getAnnotations();

        for (Annotation annotation : annotations) {
            System.out.println(annotation.toString());
            System.out.println(annotation.annotationType());
            System.out.println(annotation.getClass().getName());
            System.out.println(annotation.getClass().getTypeName());
            System.out.println(annotation.getClass().toString());
        }

        if (SSHClient.class.isAnnotationPresent(Component.class)) {
            System.out.println("find Component annotation");
        }

        Annotation annotation = SSHClient.class.getAnnotation(Component.class);

        System.out.println(annotation.toString());
        System.out.println(annotation.annotationType());
        System.out.println(annotation.getClass().getName());
        System.out.println(annotation.getClass().getTypeName());
        System.out.println(annotation.getClass().toString());
    }
}
