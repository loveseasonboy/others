package com.base.Collections;

import java.util.*;

/**
 * 使用的同步方式--集合提供的
 */
public class Synchronization {
    public static void main(String[] args) {
        Collection c = Collections.synchronizedCollection(new ArrayList());
        List list =Collections.synchronizedList(new ArrayList<>());
        Set s =Collections.synchronizedSet(new HashSet());
        Map m =Collections.synchronizedMap(new HashMap());
    }
}
