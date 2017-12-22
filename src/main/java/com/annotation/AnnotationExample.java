package com.annotation;

public class AnnotationExample {

    @Override
    @MethodInfo(author = "hehd",date = "nov 17 2017",commments = "Main method")
    public String toString() {
        return "Override toString method";
    }
    @MethodInfo(author = "meiguo",date = "new()",commments = "old  method")
    public static void oldMethod(){
        System.out.println("old method,don't use it.");
    }
}
