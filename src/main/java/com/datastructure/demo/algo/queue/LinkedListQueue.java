package com.datastructure.demo.algo.queue;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 基于链表的链式队列
 * @Author: Webb Dong
 * @CreateDate: 2019/02/27 15:58
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/27 15:58
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class LinkedListQueue<T extends Comparable<T>> {

    /**
     * 头节点
     */
    private NormalNode<T> head;

    /**
     * 尾结点
     */
    private NormalNode<T> tail;

    /**
     * 元素数量
     */
    private int count;

    /**
     * 队列大小
     */
    private int capacity;

    public LinkedListQueue(int capacity) {
        this.capacity = capacity;
    }

    /**
     * 入队
     * @param data
     * @return
     */
    public boolean enqueue(T data) {
        if (count == capacity) {
            // 队列已满
            return false;
        }
        NormalNode<T> newNode = new NormalNode<>(data);
        if (tail == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        count++;
        return true;
    }

    /**
     * 出队
     * @return
     */
    public T dequeue() {
        if (count == 0) {
            return null;
        }
        NormalNode<T> node = head;
        head = head.getNext();
        count--;
        if (count == 0) {
            tail = null;
        }
        return node.getData();
    }

    public void printAll() {
        NormalNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + ", ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*LinkedListQueue<Integer> queue = new LinkedListQueue<>(5);
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
        queue.printAll();*/

        System.out.println(9 % 8);
    }

}
