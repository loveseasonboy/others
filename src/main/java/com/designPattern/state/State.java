package com.designPattern.state;

/**
 * 状态模式
 */
public abstract class State {
     void insertQuarter(){
         System.out.println("You inserted a quarter");
     }

     void ejectQuarter(){
         System.out.println("You haven't inserted a quarter");
     }

     void turnCrank(){
         System.out.println("You turned,but there's no quarter");
     }

     void dispense(){
         System.out.println("You need to pay first");
     }
}