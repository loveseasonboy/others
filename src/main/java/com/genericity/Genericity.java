package com.genericity;

/**
 * 泛型
 */
public class Genericity {
    /**
     * 类加载的初始化5中场景
     * 1、new的时候，读取静态字段
     * 2、通过反射的时候
     * 3、父类优先于子类（当加载子类的时候发现父类没有加载，优先加载父类）
     * 4、JVM虚拟机加载的入口，必须是main的入口。
     * 5、jdk1.7的运行期编程
     * @param args
     */
    public static void main(String[] args) {
        //Class clazz = testGC.class;字面量的使用。比较安全。会自动的检测其对应的calss的文件是否是正常的文件。不被入侵。
        //boolean.class = Boolean.TYPE;
        /**
         * 泛型的使用
         *     案列如下：
         *
         */
        Class<? extends Number> clazz = Integer.class;//编译期的约束检测以便不在运行期的时候出错。
        Class<?> clazz_1 = Integer.class;
        clazz_1 = double.class;
        Class<Integer> clazz_2 = Integer.class;
        //clazz_2=double.class;//编译不通过，原因在于，已经定义了其类型。
        clazz = double.class;
        clazz = int.class;

        /**
         *
         * RRTI 运行期
         *
         * 类型转换
         * Animal animal=new Dog();
         * Class<Dog> dogType=Dog.class;
         * Dog dog =dogType.cast(animal);1.5 提供的转换
         *
         *
         *
         */
    }
}
