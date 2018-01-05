package com.base.Collections;

import java.util.Hashtable;

/**
 * hashTable  继承dictionary 线程安全的，但是效率比较低
 */
public class Counter {
    int i = 1;

    public String toString() {
        return Integer.toString(i);
    }
}

class Statistics {
    public static void main(String[] args) {
        Hashtable ht = new Hashtable();
        for (int i = 0; i < 1000; i++) {
            Integer r = new Integer((int) (Math.random() * 20));
            if (ht.containsKey(r)) {
                ((Counter) ht.get(r)).i++;
            } else {
                ht.put(r, new Counter());
            }
        }
        System.out.println(ht);
    }
}