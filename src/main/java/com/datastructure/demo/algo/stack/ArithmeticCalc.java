package com.datastructure.demo.algo.stack;

/**
 * @Description: 栈在表达式求值中的应用
 * 思路:
 *      通过两个栈来实现，其中一个保存操作数的栈，另一个是保存运算符的栈。我们从左向右遍历表达式，当遇到数字
 *      我们直接压入操作数栈，当遇到运算符，就与运算符栈的栈顶元素进行比较。
 *          1、如果比运算符栈顶元素的优先级高，就将当前运算符压入栈；
 *          2、如果比运算符栈顶元素的优先级低或者相同，从运算符栈中取栈顶运算符，从操作数栈的栈顶取2个操作数，
 *              然后进行计算再把计算完的结果压入操作数栈，继续比较
 * @Author: Webb Dong
 * @CreateDate: 2019/02/20 14:58
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/20 14:58
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ArithmeticCalc {

    /**
     * 操作数栈
     */
    private ArrayDilatationStack<Double> operandStack;

    /**
     * 运算符栈
     */
    private ArrayDilatationStack<Character> operatorStack;

    public ArithmeticCalc() {
        operandStack = new ArrayDilatationStack<>(5);
        operatorStack = new ArrayDilatationStack<>(4);
    }

    /**
     * 计算
     * @param value
     * @return
     */
    public double calculate(String value) {
        if (value == null || value.length() == 0) {
            return 0;
        }
        operandStack.clear();
        operatorStack.clear();
        analyze(value);
        return calcTotalRes();
    }

    /**
     * 分析，拆分操作数与运算符
     * 不使用正则表达式方式
     * @param value
     */
    private void analyze(String value) {
        char[] chars = value.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0, length = chars.length; i < length; i++) {
            char c = chars[i];
            if (isOperator(c)) {
                operandStack.push(Double.valueOf(sb.toString()));
                Character o = operatorStack.peek();
                if (o == null || isHighPriority(c, o)) {
                    operatorStack.push(c);
                } else {
                    while (o != null && !isHighPriority(c, o)) {
                        Double num2 = operandStack.pop();
                        Double num1 = operandStack.pop();
                        o = operatorStack.pop();
                        operandStack.push(calc(num1, num2, o));
                        o = operatorStack.peek();
                    }
                    operatorStack.push(c);
                }
                sb.delete(0, sb.length());
            } else {
                sb.append(c);
            }

            if (i == length - 1) {
                operandStack.push(Double.valueOf(sb.toString()));
            }
        }

        Character o = operatorStack.peek();
        if (isHighPriority(o)) {
            Double num2 = operandStack.pop();
            Double num1 = operandStack.pop();
            o = operatorStack.pop();
            operandStack.push(calc(num1, num2, o));
        }
    }

    /**
     *
     * @return
     */
    private double calcTotalRes() {
        Character o = operatorStack.pop();
        while (o != null) {
            Double num2 = operandStack.pop();
            Double num1 = operandStack.pop();
            operandStack.push(calc(num1, num2, o));
            o = operatorStack.pop();
        }
        return operandStack.pop();
    }

    /**
     * 计算
     * @param num1
     * @param num2
     * @param operator
     */
    private double calc(Double num1, Double num2, char operator) {
        double res = 0;
        switch (operator) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num1 - num2;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num1 / num2;
                break;
            default:
                break;
        }
        return res;
    }

    /**
     * 是否是运算符
     * @param c
     * @return
     */
    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    /**
     * 如果a运算符优先级比b高，返回true
     * @param a
     * @param b
     * @return
     */
    private boolean isHighPriority(char a, char b) {
        return (a == '*' || a == '/') && (b == '+' || b == '-');
    }

    /**
     *
     * @param a
     * @return
     */
    private boolean isHighPriority(char a) {
        return (a == '*' || a == '/');
    }

    public static void main(String[] args) {
        ArithmeticCalc stack = new ArithmeticCalc();
        System.out.println(stack.calculate("34+13*9+44-12/3"));
        System.out.println(stack.calculate("34+13*9+44-12/3-10"));
        System.out.println(stack.calculate("1000-20-30-40/3"));
        System.out.println(stack.calculate("3-5*8-6"));
        System.out.println(stack.calculate("3+5*8-6"));
        System.out.println(stack.calculate("34+13*9+44-12/3+5+2"));
    }

}
