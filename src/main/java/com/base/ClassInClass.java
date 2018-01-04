package com.base;

import static com.base.WithInner.*;

/**
 * 内部类的方式：
 * 1.mothed中的内部类
 * 2.类中的内部类
 */

/**
 * 内部类的标识符
 * .class 中内部类的显示方式是
 * WithInner$inner.class标识inner是WithInner的内部类
 */
public class ClassInClass {
    public ClassInClass read() {
        return new ClassInClass() {
            class Peason {
                private int i = 10;

                int print() {
                    return i;
                }
            }
        };
    }

    public static void main(String[] args) {
        ClassInClass cc= new ClassInClass().read();

    }
}

class Parcel {
    private class Contents {
        private int i = 11;

        public int value() {
            return i;
        }
    }

    class Destination {
        private String label;

        public Destination(String label) {
            this.label = label;
        }

        String readLabel() {
            return label;
        }
    }

    /**
     * 通过外部类的句柄来应用对象内的类的实例。如下所示
     * 包括其私有的属性
     *
     * @param args
     */
    public static void main(String[] args) {
        Parcel p = new Parcel();
        Parcel.Contents c = p.new Contents();
        System.out.println(c.value());
        Parcel.Destination d = p.new Destination("张三");
        System.out.println(d.readLabel());
    }
}
class WithInner{
    /**
     * 创建对象的时候就初始化内部类
     */
    private Inner i=new Inner(2);
    public WithInner() {
        System.out.println("构造器");
    }
    {
        new Inner();
    }
    class Inner{
        public Inner() {
            System.out.println("内部类构造器");
        }
        public Inner(int i) {
            System.out.println("private 初始化内部类构造器");
        }
    }
}

/**
 * 继承内部类的时候必须要有构造器
 * 必须是如下的格式，其他的构造是错误的
 */
class InheritInner extends WithInner.Inner{
    InheritInner(WithInner wi){
        wi.super();
    }
    public static void main(String[] args) {
        WithInner wi=new WithInner();
        InheritInner ii=new InheritInner(wi);
    }
}