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
        this.elements = (T[]) new Object[capacity + 1];
        this.capacity = capacity + 1;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(T data) {
        int newTail = (tail + 1) % capacity;
        if (newTail == head) {
            // 队列已满
            return false;
        }
        this.elements[tail] = data;
        tail = newTail;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (head == tail) {
            // 队列为空
            return null;
        }
        T element = this.elements[head];
        head = (head + 1) % capacity;
        return element;
    }

    public void printAll() {
        if (capacity == 0) {
            return;
        }
        int i = head;
        while (i % capacity != tail) {
            System.out.print(this.elements[i] + ", ");
            i = (i + 1) % capacity;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue<Integer> queue = new CircularQueue<>(5);
        queue.enqueue(100);
        queue.enqueue(200);
        queue.enqueue(300);
        queue.enqueue(400);
        queue.enqueue(500);
        queue.enqueue(600);

        queue.printAll();
        queue.dequeue();
        queue.dequeue();
        queue.dequeue();
        queue.printAll();

        queue.enqueue(1000);
        queue.enqueue(2000);
        queue.enqueue(3000);
        queue.enqueue(4000);
        queue.enqueue(5000);
        queue.enqueue(6000);
        queue.enqueue(7000);
        queue.printAll();

        System.out.println("-------------------------------------------");
        Integer data = queue.dequeue();
        while (data != null) {
            System.out.print(data + ", ");
            data = queue.dequeue();
        }
        System.out.println();
        System.out.println("-------------------------------------------");

        queue.enqueue(10000);
        queue.enqueue(20000);
        queue.enqueue(30000);
        queue.enqueue(40000);
        queue.enqueue(50000);
        queue.enqueue(60000);
        queue.enqueue(70000);
        queue.printAll();
    }

}
