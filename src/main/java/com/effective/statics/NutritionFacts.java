package com.effective.statics;

/**
 * 重叠构造参数的最好的办法；主要用于多次创建对象
 * 方法三：（构建器）
 * 1、方便赋值，也不会弄错参数的意思
 * 2、用于4个或者多个情况
 * 3、更加安全（比javaBean）
 */
public class NutritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;
    private final int sodium;
    private final int carbohydrate;
    /**
     * 方法一：
     * 多参数的时候通过构造器来实现
     * 缺点：1、容易看不到参数是什么意思
     *      2、一旦参数写反了也不方便发现
     * 方法二：
     * 通过javaBean 的通过setter和getter来赋值替换
     * 缺点：1、不方便阅读，会写和很多的setter和getter
     */
//    public NutritionFacts(int servingSize, int servings) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//    }
//
//    public NutritionFacts(int servingSize, int servings, int calories, int fat, int sodium, int carbohydrate) {
//        this.servingSize = servingSize;
//        this.servings = servings;
//        this.calories = calories;
//        this.fat = fat;
//        this.sodium = sodium;
//        this.carbohydrate = carbohydrate;
//    }


    public static class Builder implements Build<NutritionFacts> {
        private final int servingSize;
        private final int servings;
        private int calories = 0;
        private int fat = 0;
        private int sodium = 0;
        private int carbohydrate = 0;

        public Builder(int servingSize, int servings) {
            this.servingSize = servingSize;
            this.servings = servings;
        }

        public Builder calories(int val) {
            calories = val;
            return this;
        }

        public Builder fat(int val) {
            fat = val;
            return this;
        }

        public Builder carbohydrate(int val) {
            carbohydrate = val;
            return this;
        }

        public Builder sodium(int val) {
            sodium = val;
            return this;
        }

        public NutritionFacts build() {
            return new NutritionFacts(this);
        }
    }

    private NutritionFacts(Builder builder) {
        servingSize = builder.servingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
        sodium = builder.sodium;
        carbohydrate = builder.carbohydrate;
    }

    public static void main(String[] args) {
        NutritionFacts cocaCola=new NutritionFacts.Builder(240,8).fat(5).build();

    }
}
