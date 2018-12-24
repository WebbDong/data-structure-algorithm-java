package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.SinglyNode;

/**
 * @Description:    单链表
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
public class SinglyLinkedList<T> {

    /**
     * 头节点
     */
    private SinglyNode<T> head;

    /**
     * 尾结点
     */
    private SinglyNode<T> last;

    /**
     * 根据索引查找
     * @param index
     * @return
     */
    public SinglyNode<T> findByIndex(int index) {
        int i = 0;
        SinglyNode<T> currentNode = head;
        while (currentNode != null) {
            if (index == i) {
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * 根据值查找
     * @param data
     * @return
     */
    public SinglyNode<T> findByValue(T data) {
        int i = 0;
        SinglyNode<T> currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData() == data
                    || (data != null && data.equals(currentNode.getData()))) {
                return currentNode;
            }
            i++;
            currentNode = currentNode.getNext();
        }
        return null;
    }

    /**
     * 插入到头部
     * @param data
     */
    public void insertToHead(T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(SinglyNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
        }
    }

    /**
     * 插入到尾部
     * @param data
     */
    public void insertToTail(T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertToTail(newNode);
    }

    /**
     * 插入到尾部
     * @param newNode
     */
    public void insertToTail(SinglyNode<T> newNode) {
        if (head == null) {
            head = newNode;
            last = newNode;
        } else {
            last.setNext(newNode);
            last = newNode;
        }
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param data
     */
    public void insertBefore(SinglyNode<T> node, T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertBefore(node, newNode);
    }

    /**
     * 插入到指定元素之前
     * @param node
     * @param newNode
     */
    public void insertBefore(SinglyNode<T> node, SinglyNode<T> newNode) {
        if (node == null || newNode == null || head == null) {
            return;
        }

        SinglyNode<T> currentNode = head;
        SinglyNode<T> preNode = null;
        while (currentNode != null) {
            if (node.getData().equals(currentNode.getData())) {
                if (preNode == null) {
                    newNode.setNext(currentNode);
                    head = newNode;
                } else {
                    newNode.setNext(preNode.getNext());
                    preNode.setNext(newNode);
                }
                break;
            }
            preNode = currentNode;
            currentNode = currentNode.getNext();
        }
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param data
     */
    public void insertAfter(SinglyNode<T> node, T data) {
        SinglyNode<T> newNode = new SinglyNode<>(data);
        insertAfter(node, newNode);
    }

    /**
     * 插入到指定元素之后
     * @param node
     * @param newNode
     */
    public void insertAfter(SinglyNode<T> node, SinglyNode<T> newNode) {
        if (node == null || newNode == null) {
            return;
        }
        newNode.setNext(node.getNext());
        node.setNext(newNode);
    }

    /**
     * 打印所有元素
     */
    public void printAll() {
        SinglyNode<T> currentNode = head;
        while (currentNode != null) {
            System.out.print(currentNode.getData() + ", ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
        System.out.println("-------------------------------");
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> list1 = new SinglyLinkedList<>();
        list1.insertToHead(100);
        list1.insertToHead(200);
        list1.insertToHead(300);
        list1.printAll();

        SinglyLinkedList<Integer> list2 = new SinglyLinkedList<>();
        list2.insertToTail(700);
        list2.insertToTail(800);
        list2.insertToTail(900);
        list2.printAll();

        SinglyNode<Integer> node1 = list2.findByIndex(1);
        System.out.println("list2.findByIndex(1) = " + node1);

        SinglyNode<Integer> node2 = list2.findByValue(900);
        System.out.println("list2.findByValue(900) = " + node2);
    }

}
