package com.exception;

/**
 * 测试列外和retur的区别
 * 通过debug测试得到的是先进入finally 在返回值的。
 * 只是这个值在return的时候已经被保存好了，不在被finally中的代码改变
 * 也就是说。如果return在finally之后的纸就会被改变。
 */
public class ExceptionDemo {
    public static void main(String[] args) {
        //输出的只是1
        System.out.println(getInt());
    }

    public static int getInt() {
        int a = 1;
        try {
            //输出的值是1
            System.out.println(a);
            return a;
        } catch (Exception e) {

        } finally {
            //输出的值是2
            a++;
            System.out.println(a);
        }
        return a;
    }
}
