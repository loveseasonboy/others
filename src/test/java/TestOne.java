public class TestOne {
    /**
     * 位运算 & | ^ 是可以操作的boolean的类型是比较特别的。表示两个函数都会执行，不会短路。~ 非运算用不了。
     * @param args
     */
    public static void main(String[] args) {
        if (one() ^ two()) {
            System.out.println("位运算符");
        } else {
            System.out.println("。。。。。");
        }

        int i =1;
        System.out.println(i >>> 2);//0
        System.out.println(i >> 2);//0
        System.out.println(i << 2);//4
        System.out.println(8 >>> 2);//1 2 4 8
        System.out.println(-8 >>> 1);
    }

    private static boolean one() {
        System.out.println("方法one的调用,返回值是true");
        return true;
    }

    private static boolean two() {
        System.out.println("方法two的调用，返回值是true");
        return true;
    }

    private static boolean three() {
        System.out.println("方法three的调用，返回值是false");
        return false;
    }

    private boolean four() {
        System.out.println("方法four的调用，返回值是false");
        return false;
    }
}
