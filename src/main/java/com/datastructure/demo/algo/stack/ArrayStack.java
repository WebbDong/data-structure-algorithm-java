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
        this.capacity = 0;
    }

    public static void main(String[] args) {

    }

}
