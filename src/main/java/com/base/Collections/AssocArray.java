package com.base.Collections;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Vector;

/**
 * 自定义的集合
 * 覆盖dictionary中的所有的方法
 * 使用vector来实现增删改查
 */
public class AssocArray extends Dictionary {
    private Vector keys = new Vector();
    private Vector values = new Vector();

    @Override
    public int size() {
        return keys.size();
    }

    @Override
    public boolean isEmpty() {
        return keys.isEmpty();
    }

    @Override
    public Enumeration keys() {
        return keys.elements();
    }

    @Override
    public Enumeration elements() {
        return values.elements();
    }

    @Override
    public Object get(Object key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        return values.elementAt(index);
    }

    @Override
    public Object put(Object key, Object value) {
        keys.addElement(key);
        values.addElement(value);
        return key;
    }

    @Override
    public Object remove(Object key) {
        int index = keys.indexOf(key);
        if (index == -1) {
            return null;
        }
        keys.removeElementAt(index);
        Object returnVal = values.elementAt(index);
        values.removeElementAt(index);
        return returnVal;
    }

    public static void main(String[] args) {
        AssocArray aa = new AssocArray();
        for (char c = 'a'; c <= 'z'; c++) {
            aa.put(String.valueOf(c), String.valueOf(c).toUpperCase());
        }
        char[] ca = {'a', 'e', 'i', 'o', 'u'};
        for (int i = 0; i < ca.length; i++) {
            System.out.println("Uppercase:" + aa.get(String.valueOf(ca[i])));
        }
    }
}
