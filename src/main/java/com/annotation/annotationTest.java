package com.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class annotationTest {
    public static void main(String[] args) {
        Class<?> clazz = AnnotationExample.class;
        Method[] methods = clazz.getMethods();
        Field[] field=clazz.getFields();//clazz.getField("sss");获取的是公开的属性
        Field[] fields=clazz.getDeclaredFields();//获取所有的属性
        Field field1=field[0];
        field1.getGenericType();//获取属性类型
        field1.setAccessible(true);
        for (Method m : methods) {
            for (Annotation annotation:m.getDeclaredAnnotations()){
                System.out.println(annotation);
                MethodInfo methodInfo=m.getAnnotation(MethodInfo.class);
                System.out.println(methodInfo.author()+":"+m.getName()+":"+m.getDeclaringClass());
            }
        }
    }
}
