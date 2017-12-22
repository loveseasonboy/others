package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class annotationTest {
    public static void main(String[] args) {
        Class<?> clazz = AnnotationExample.class;
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            for (Annotation annotation:m.getDeclaredAnnotations()){
                System.out.println(annotation);
                MethodInfo methodInfo=m.getAnnotation(MethodInfo.class);
                System.out.println(methodInfo.author()+":"+m.getName()+":"+m.getDeclaringClass());
            }
        }
    }
}
