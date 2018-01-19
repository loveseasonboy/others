package com.stack;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Stack;

/**
 * 波兰表达式法(后缀表达式)
 */
public class StackTest {
    /**
     * 作业，写程序将中缀表达式转出后缀表达式，再计算其结果
     * 中缀表达式 9+（3-1）*3+10/2 = 20 转后缀931-3*+10 2/+
     * <p>
     * 931-3*+10 2/+
     * 923*+10 2/ +
     * 96+10 2/ +
     * 15 10 2/ +
     * 15 5 +
     * 20
     */
    //定义优先级
    static int topPriority = 1 << 2;
    static int otherPriority = 1 << 1;
    //存放四则运算的优先级
    static Map<String, Object> map = new HashMap<>();

    static void init() {
        map.put("*", topPriority);
        map.put("/", topPriority);
        map.put("+", otherPriority);
        map.put("-", otherPriority);
        map.put("（", 0);
        map.put("）", 0);
    }

    public static void main(String[] args) {
        init();
        //中缀表达式 9+（3-1）*3+10/2 = 20 转后缀931-3*+10 2/+
        //String str = "9+（3-1）*3+10/2";
        String str = "12+（6-1）+10*2+10-5*2";
        StringBuilder sb = initNumber(str);
        String suffix = suffix(sb.toString());
        System.out.println(suffix);
        int sum = execute(suffix);
        System.out.println(sum);
    }

    static int execute(String suffix) {
        String[] split = suffix.split(",");
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]+")) {
                stack.push(Integer.parseInt(split[i]));
            } else {
                if (stack.size() > 1) {
                    int topStack = stack.pop();
                    int secendStack = stack.pop();
                    int sum = 0;
                    if ("+".equals(split[i])) {
                        sum = topStack + secendStack;
                    } else if ("-".equals(split[i])) {
                        sum = secendStack - topStack;
                    } else if ("*".equals(split[i])) {
                        sum = secendStack * topStack;
                    } else if ("/".equals(split[i])) {
                        sum = secendStack / topStack;
                    }
                    stack.push(sum);
                }
            }
        }
        return stack.pop();
    }

    static String suffix(String str) {
        String[] split = str.split(",");
        //定义一个栈
        Stack<String> stack = new Stack<>();
        StringBuilder number = new StringBuilder();
        //1.循环str取出每一个元素
        for (int i = 0; i < split.length; i++) {
            if (split[i].matches("[0-9]+")) {
                number.append(split[i] + ",");
            } else {
                join(split[i], number, stack);
            }
        }
        if (stack.size() > 0) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                number.append(stack.get(i) + ",");
            }
        }
        System.out.println(number.substring(0, number.length() - 1));
        return number.substring(0, number.length() - 1);
    }

    static void join(String c, StringBuilder number, Stack<String> stack) {
        //优先级最高
        if ("）".equals(c)) {
            while (true) {
                String pop = stack.pop();
                if ("（".equals(pop)) {
                    break;
                } else {
                    number.append(pop + ",");
                }
            }
            return;
        }
        if (stack.size() > 0) {
            if (!"（".equals(c)) {
                int current = (int) map.get(c);
                int topStack = (int) map.get(stack.peek());
                //栈中的符号优先级比当前的高，一起出栈
                if (topStack > current) {
                    number.append(stack.pop() + "," + c + ",");
                    return;
                }
            }
        }
        stack.push(c);
    }

    static StringBuilder initNumber(String number) {
        Stack<String> stack = new Stack<>();
        //存放一个整数
        StringBuilder sb = new StringBuilder();
        String[] str = {"+", "-", "*", "/", "）", "（"};
        //1.循环str取出每一个元素
        for (int i = 0; i < number.length(); i++) {
            String c = String.valueOf(number.charAt(i));
            boolean flag = false;
            for (int j = 0; j < str.length; j++) {
                if (c.equals(str[j])) {
                    flag = true;
                }
            }
            if (flag) {
                String num = "";
                Iterator<String> iterator = stack.iterator();
                while (iterator.hasNext()) {
                    String pop = iterator.next();
                    num = num + pop;
                    iterator.remove();
                }
                if ("".equals(num)) {
                    sb.append(c + ",");
                } else {
                    sb.append(num + "," + c + ",");
                }
            } else {
                stack.push(c);
            }
        }
        if (stack != null) {
            String num = "";
            Iterator<String> iterator = stack.iterator();
            while (iterator.hasNext()) {
                String pop = iterator.next();
                num = num + pop;
                iterator.remove();
            }
            sb.append(num);
        }
        return sb;
    }
}
