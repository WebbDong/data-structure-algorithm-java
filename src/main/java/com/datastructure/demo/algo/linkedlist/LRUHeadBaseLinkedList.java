package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 基于带头链表的最近最少使用策略LRU(Least Recently Used)
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历
 *   1、如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 *   2、如果此数据没有再缓存链表中，又分为2种情况
 *      a：如果此时缓存未满，则将此结点直接插入到链表的头部；
 *      b：如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部；
 * @Author: Webb Dong
 * @CreateDate: 2019/02/15 11:23
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/15 11:23
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class LRUHeadBaseLinkedList<T extends Comparable<T>> {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 5;

    /**
     * 链表长度
     */
    private int size;

    /**
     * 头节点
     */
    private NormalNode<T> head;

    /**
     * 链表容量
     */
    private Integer capacity;

    public LRUHeadBaseLinkedList() {
        this.head = new NormalNode<>();
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

    /**
     * 添加元素
     * @param data
     */
    public void add(T data) {
        NormalNode<T> preNode = findPreNode(data);
        if (preNode == null) {
            // 元素不在链表中
            if (size >= capacity) {
                deleteEndNode();
            }
            insertNodeAtHead(data);
        } else {
            // 元素在链表中
            deleteNextNode(preNode);
            insertNodeAtHead(data);
        }
    }

    /**
     * 删除下一个节点
     * @param preNode
     */
    private void deleteNextNode(NormalNode<T> preNode) {
        NormalNode<T> temp = preNode.getNext();
        preNode.setNext(temp.getNext());
        temp.setNext(null);
        size--;
    }

    /**
     * 删除尾节点
     */
    private void deleteEndNode() {
        NormalNode<T> currentNode = head;
        if (currentNode.getNext() == null) {
            return;
        }
        while (currentNode.getNext().getNext() != null) {
            currentNode = currentNode.getNext().getNext();
        }

        currentNode.setNext(null);
        size--;
    }

    /**
     * 插入到链表头部
     * @param data
     */
    private void insertNodeAtHead(T data) {
        NormalNode<T> newNode = new NormalNode<>(data);
        newNode.setNext(head.getNext());
        head.setNext(newNode);
        size++;
    }

    /**
     * 查找指定数据节点的上一个节点
     * @param data
     * @return
     */
    private NormalNode<T> findPreNode(T data) {
        NormalNode<T> currentNode = head;
        while (currentNode.getNext() != null) {
            if (data.equals(currentNode.getNext().getData())) {
                return currentNode;
            }
            currentNode = currentNode.getNext();
        }
        return null;
    }

    private void printAll() {
        NormalNode<T> currentNode = head;
        while (currentNode.getNext() != null) {
            System.out.print(currentNode.getNext().getData() + ", ");
            currentNode = currentNode.getNext();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LRUHeadBaseLinkedList list = new LRUHeadBaseLinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        list.add(10);
        list.printAll();
        list.add(100);
        list.printAll();
        list.add(200);
        list.printAll();
        list.add(40);
        list.printAll();
        list.add(10);
        list.printAll();
    }

}
