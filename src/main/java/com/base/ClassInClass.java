package com.base;

public class ClassInClass {
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