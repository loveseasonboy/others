package com.gc;

public class testGC {
    private static final int _1M = 1024 * 1024;

    public static void main(String[] args) {
        byte[] byte1, byte2, byte3, byte4;
        System.gc();
        byte1 = new byte[2 * _1M];
        byte2 = new byte[2 * _1M];
        byte3 = new byte[2 * _1M];
        byte4 = new byte[4 * _1M];

    }
}
