package com.datastructure.demo.algo.stack;

/**
 * @Description: 基于数组的顺序栈
 * @Author: Webb Dong
 * @CreateDate: 2019/02/18 18:11
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/18 18:11
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ArrayStack<T> {

    /**
     * 数组
     */
    private T[] elements;

    /**
     * 元素个数
     */
    private int count;

    /**
     * 栈大小
     */
    private int capacity;

    public ArrayStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 入栈
     * @param element
     * @return
     */
    public boolean push(T element) {
        if (count == capacity) {
            // 栈已满
            return false;
        }

        this.elements[count++] = element;
        return true;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        if (count == 0) {
            return null;
        }

        T element = this.elements[--count];
        this.elements[count] = null;
        return element;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);

        for (int i = 0; i < 10; i++) {
            System.out.println(stack.pop());
        }
    }

}
