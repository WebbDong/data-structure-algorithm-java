package com.datastructure.demo.algo.queue;

/**
 * @Description: 基于
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
     * 元素个数
     */
    private int count;

    /**
     * 栈大小
     */
    private int capacity;

    private int i;

    public ArrayQueue(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.capacity = capacity;
        this.count = 0;
        this.i = 0;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public void enqueue(T data) {
        dilatation();
        this.elements[count++] = data;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (count == 0) {
            return null;
        }
        T data = this.elements[i++];
        count--;
        return data;
    }

    public int getCount() {
        return this.count;
    }

    /**
     * 扩容
     */
    private void dilatation() {
        if (capacity == count) {
            resize(this.capacity * 2);
        }
    }

    /**
     * 调整大小
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newElements[i] = this.elements[i];
        }
        this.capacity = newCapacity;
        this.elements = newElements;
    }

    public static void main(String[] args) {
        ArrayQueue<Integer> queue = new ArrayQueue<>(4);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);

        for (int i = 0, length = queue.getCount(); i < length; i++) {
            System.out.println(queue.dequeue());
        }

        queue.enqueue(1000);
        queue.enqueue(2000);
        queue.enqueue(3000);
        queue.enqueue(4000);
        queue.enqueue(5000);
        queue.enqueue(6000);
        queue.enqueue(7000);

        for (int i = 0, length = queue.getCount(); i < length; i++) {
            System.out.println(queue.dequeue());
        }
    }

}
