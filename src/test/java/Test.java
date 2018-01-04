public class Test {
    public static void main(String[] args) {
        int i =-1;
        i >>>=1;
        System.out.println(i);
        System.out.println(1<< 2);
        i=1;
        /**
         * continue 和break 中可以使用 标识符来退出到标识符位置
         * continue 标识符；表示退到标识符位置继续循环
         * break 标识符：表示退到标识符位置不在循环
         * return 直接退出程序，之后的程序不在执行。
         */
        outer:
        while (true){
            i++;
            if(i<2){
                System.out.println("111");
                continue outer;
            }
            System.out.println(i);
            System.out.println("222");
            break outer;
        }
        System.out.println("333");
        print("123",1);
        print(2,"456");
    }

    /**
     * 重载：方法名相同，参数不同
     * 当参数相同，顺序不同也是可以的
     * @param s
     * @param i
     */
    static void print(String s, int i) {
        System.out.println(
                "String: " + s +
                        ", int: " + i);
    }
    static void print(int i, String s) {
        System.out.println(
                "int: " + i +
                        ", String: " + s);
    }

}
