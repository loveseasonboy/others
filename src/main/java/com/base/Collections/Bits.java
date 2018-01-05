package com.base.Collections;

import java.util.BitSet;
import java.util.Random;

/**
 * BitSet
 */
public class Bits {
    public static void main(String[] args) {
        Random random = new Random();
        byte bt = (byte) random.nextInt();
        BitSet bs = new BitSet();
        for (int i = 7; i >= 0; i--) {
            if (((1 << i) & bt) != 0) {
                bs.set(i);
            } else {
                bs.clear();
            }
        }
        System.out.println("byte value:" + bt);
        printBitSet(bs);
        short st = (short) random.nextInt();
        BitSet bs1 = new BitSet();
        for (int i = 15; i >= 0; i--) {
            if (((1 << i) & st) != 0) {
                bs1.set(i);
            } else {
                bs1.clear();
            }
        }
        System.out.println("short value:" + st);
        int it = random.nextInt();
        BitSet bi = new BitSet();
        for (int i = 31; i >= 0; i--) {
            if (((1 << i) & it) != 0) {
                bi.set(i);
            } else {
                bi.clear();
            }
        }
        System.out.println("int value" + it);
        printBitSet(bi);
        BitSet b127 = new BitSet();
        b127.set(127);
        System.out.println("set bit 127:" + b127);
        BitSet b255 = new BitSet(65);
        b255.set(255);
        System.out.println("set bit 255:" + b255);
        BitSet b1023 = new BitSet(512);
        b1023.set(1024);
        System.out.println("set bit 1023:" + b1023);
    }

    static void printBitSet(BitSet b) {
        System.out.println("bits:" + b);
        String bbits = new String();
        for (int j = 0; j < b.size(); j++) {
            bbits += (b.get(j) ? "1" : "0");
        }
        System.out.println("bit pattern:" + bbits);
    }
}
