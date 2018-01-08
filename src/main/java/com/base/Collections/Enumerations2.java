package com.base.Collections;

import com.sun.org.apache.xpath.internal.operations.String;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;

public class Enumerations2 {
    static void print(Enumeration e) {
        while (e.hasMoreElements()) {
            System.out.println(e.nextElement().toString());
        }
    }
    public static void main(String[] args) {
        Vector v = new Vector();
        for (int i = 0; i < 5; i++) {
            v.addElement("vector:" + i);
        }
        Hashtable h = new Hashtable();
        for (int i = 0; i < 5; i++) {
            h.put(new Integer(i), "hashtable：" + i);
        }
        Enumerations2.print(v.elements());
        Enumerations2.print(h.elements());
    }
}

