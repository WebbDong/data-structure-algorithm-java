package com.datastructure.demo.algo.queue;

/**
 * @Description: 基于数组的顺序队列
 * @Author: Webb Dong
 * @CreateDate: 2019/02/22 16:58
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/22 16:58
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ArrayQueue<T> {

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

    public ArrayQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.head = 0;
        this.tail = 0;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(T data) {
        if (tail == capacity) {
            return false;
        }
        this.elements[tail++] = data;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            return null;
        }
        return this.elements[head++];
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(5);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);

        for (int i = 0, length = 5; i < length; i++) {
            System.out.println(queue.dequeue());
        }

        queue.enqueue(1000);
        queue.enqueue(2000);
        queue.enqueue(3000);
        queue.enqueue(4000);
        queue.enqueue(5000);
        queue.enqueue(6000);
        queue.enqueue(7000);

        for (int i = 0, length = 5; i < length; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
