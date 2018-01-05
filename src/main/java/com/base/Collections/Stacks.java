package com.base.Collections;

import java.util.Stack;

/**
 *stack 继承vector  线程是安全的
 */
public class Stacks {
    static String[] moths = {"January", "February", "March", "April",
            "May", "June", "July", "August", "September",
            "October", "November", "December"};

    public static void main(String[] args) {
        Stack stk = new Stack();
        for (int i = 0; i < moths.length; i++) {
            stk.push(moths[i] + " ");//和vector 的addElement 是一样的
        }
        System.out.println("stk=" + stk);
        stk.addElement("The last line");//压栈
        System.out.println("element 5="+stk.elementAt(5));
        System.out.println("popping element:");
        while (!stk.empty()){
            System.out.println(stk.pop());
        }
    }
}
