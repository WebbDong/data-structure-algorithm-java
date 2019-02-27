package com.datastructure.demo.algo.queue;

/**
 * @Description: 循环队列，解决ArrayDilatationQueue搬移数据的效率问题
 * @Author: Webb Dong
 * @CreateDate: 2019/02/27 18:26
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/27 18:26
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class CircularQueue<T> {

    /**
     * 元素
     */
    private T[] elements;

    /**
     * 队列大小
     */
    private int capacity;

    /**
     * 头下标
     */
    private int head;

    /**
     * 尾下标
     */
    private int tail;

    public CircularQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
    }

}
