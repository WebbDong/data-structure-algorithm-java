package com.datastructure.demo.algo.stack;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 基于链表的链式栈
 * @Author: Webb Dong
 * @CreateDate: 2019/02/22 12:36
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/22 12:36
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class LinkedStack<T extends Comparable<T>> {

    private NormalNode<T> head;

    private int count;

    public LinkedStack() {
    }

    /**
     * 入栈
     * @param data
     */
    public void push(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
        count++;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        if (head == null) {
            return null;
        }
        T data = head.getData();
        head = head.getNext();
        count--;
        return data;
    }

    /**
     * 获取栈顶元素，不弹栈
     * @return
     */
    public T peek() {
        if (head == null) {
            return null;
        }
        return head.getData();
    }

    /**
     * 是否是空栈
     * @return
     */
    public boolean isEmpty() {
        return head == null;
    }

    public void printAllElement() {
        NormalNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + ", ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedStack<Integer> stack = new LinkedStack<>();
        stack.push(1000);
        stack.push(2000);
        stack.push(3000);
        stack.push(4000);
        System.out.println(stack.peek());
        stack.printAllElement();

        Integer e = stack.pop();
        while (e != null) {
            System.out.println(e);
            e = stack.pop();
        }
    }

}
