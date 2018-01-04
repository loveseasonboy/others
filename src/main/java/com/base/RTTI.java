package com.base;

/**
 * 运行期类型标识
 */
public class RTTI {
    public static void main(String[] args) {
        outer://continue 和continue 标识符效果是一样的
        for (int i=0;i<10;i++){
            if(i==5){
                System.out.println("可以跳出了");
                continue outer;
            }
            System.out.print(i+",");
        }
        Useful[] x = {new Useful(), new MoreUseful()};
        x[0].f();
        x[1].g();
        ((MoreUseful) x[1]).u();
        //java.lang.ClassCastException
        ((MoreUseful) x[0]).u();//下溯造型出现异常
    }
}

class Useful {
    public void f() {
    }

    public void g() {
    }
}

class MoreUseful extends Useful {
    @Override
    public void f() {
    }

    @Override
    public void g() {
    }

    public void u() {
    }

    public void v() {
    }
}