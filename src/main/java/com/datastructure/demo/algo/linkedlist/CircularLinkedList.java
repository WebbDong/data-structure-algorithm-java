package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 循环链表
 * @Author: Webb Dong
 * @CreateDate: 2018/12/28 10:28
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2018/12/28 10:28
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class CircularLinkedList<T> {

    /**
     * 头节点
     */
    private NormalNode<T> head;

    /**
     * 尾结点
     */
    private NormalNode<T> last;

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public NormalNode<T> findByIndex(int index) {
        int i = 0;
        NormalNode<T> currentNode = head;
        if (currentNode != null) {
            do {
                if (index == i) {
                    return currentNode;
                }
                i++;
                currentNode = currentNode.getNext();
            } while (currentNode != head);
        }
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public NormalNode<T> findByValue(T data) {
        NormalNode<T> currentNode = head;
        if (currentNode != null) {
            do {
                if (currentNode.getData() == data
                        || (data != null && data.equals(currentNode.getData()))) {
                    return currentNode;
                }
                currentNode = currentNode.getNext();
            } while (currentNode.getData() == data || (data != null && data.equals(currentNode.getData())));
        }
        return null;
    }

    /**
     * 插入到头部
     * @param data
     */
    public void insertToHead(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(NormalNode<T> newNode) {
        if (head == null) {
            newNode.setNext(newNode);
            head = newNode;
            last = newNode;
        } else {
            newNode.setNext(head);
            last.setNext(newNode);
            head = newNode;
        }
    }

    /**
     * 插入到尾部
     * @param data
     */
    public void insertToTail(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertToTail(newNode);
    }

    /**
     * 插入到尾部
     * @param newNode
     */
    public void insertToTail(NormalNode<T> newNode) {
        if (head == null) {
            newNode.setNext(newNode);
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            newNode.setNext(head);
            last = newNode;
        }
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param data
     */
    public void insertBefore(NormalNode<T> node, T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertBefore(node, newNode);
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param newNode
     */
    public void insertBefore(NormalNode<T> node, NormalNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        NormalNode<T> current = head;
        NormalNode<T> pre = null;
        do {
            pre = current;
            current = current.getNext();
        } while (current != head && current != node && !current.getData().equals(node.getData()));

        if (current == head) {
            return;
        }

        pre.setNext(newNode);
        newNode.setNext(current);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param data
     */
    public void insertAfter(NormalNode<T> node, T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        insertAfter(node, newNode);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param newNode
     */
    public void insertAfter(NormalNode<T> node, NormalNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        NormalNode<T> current = head;
        do {
            current = current.getNext();
        } while (current != head && current != node && !current.getData().equals(node.getData()));

        if (current == null) {
            return;
        }

        newNode.setNext(current.getNext());
        current.setNext(newNode);
        last = newNode;
    }

    public void printAll() {
        NormalNode<T> current = head;
        if (current != null) {
            do {
                System.out.print(current.getData() + ", ");
                current = current.getNext();
            } while (current != head);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("--------------- insertToTail -----------------");
        CircularLinkedList<Integer> list1 = new CircularLinkedList<>();
        list1.insertToTail(100);
        list1.insertToTail(200);
        list1.insertToTail(300);
        list1.insertToTail(400);
        list1.insertToTail(500);
        list1.printAll();

        System.out.println("--------------- insertToHead -----------------");
        CircularLinkedList<Integer> list2 = new CircularLinkedList<>();
        list2.insertToHead(1000);
        list2.insertToHead(2000);
        list2.insertToHead(3000);
        list2.insertToHead(4000);
        list2.insertToHead(5000);
        list2.printAll();

        System.out.println("--------------- insertAfter -----------------");
        NormalNode<Integer> node1 = list2.findByIndex(4);
        list2.insertAfter(node1, 6000);
        list2.printAll();
    }

}
