package com.base;

public class GCDemo {
    static boolean gcrun = false;
    static boolean f = false;
    static int created = 0;
    static int finalized = 0;
    int i;

    GCDemo() {
        i = ++created;
        if (created == 47) {
            System.out.println("Created 47");
        }
    }

    protected void finalize() {
        if (!gcrun) {
            gcrun = true;
            System.out.println("Beginning to finalize after" + created + "GCDemo have been created");
        }
        if (i == 47) {
            System.out.println("Finalizing GCDemo #47,Setting flag to stop GCDemo creation");
            f = true;
        }
        finalized++;
        if (finalized >= created) {
            System.out.println("All" + finalized + "finalized");
        }
    }
}

class Garbage {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: \n" +
                    "java Garbage before\n or:\n" +
                    "java Garbage after");
            return;
        }
        while (!GCDemo.f) {
            new GCDemo();
            new String("To take up space");
        }
        System.out.println("After all GCDemo have been created:total created=" + GCDemo.created
                + ",total finalized =" + GCDemo.finalized);
        if (args[0].equals("before")) {
            /**
             * 到程序结束的时候，并非所有收尾模块都会得到调用（注释④）。为强制进行收尾工作，可先调用
             System.gc()，再调用 System.runFinalization()。这样可清除到目前为止没有使用的所有对象。这样做一
             个稍显奇怪的地方是在调用runFinalization()之前调用gc()，这看起来似乎与 Sun 公司的文档说明有些抵
             触，它宣称首先运行收尾模块，再释放存储空间。然而，若在这里首先调用runFinalization()，再调用
             gc()，收尾模块根本不会执行
             */
            System.out.println("runFinalization:");
            System.runFinalization();
            System.out.println("gc()");
            System.gc();
        }
        System.out.println("bye!");
        if (args[0].equals("after")) {
            System.runFinalizersOnExit(true);
        }
    }
}