package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.DuLinkedNode;

/**
 * @Description: 双向循环链表
 * @Author: Webb Dong
 * @CreateDate: 2019/01/02 10:50
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/01/02 10:50
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class CircularDuLinkedList<T> {

    /**
     * 头节点
     */
    private DuLinkedNode<T> head;

    /**
     * 尾结点
     */
    private DuLinkedNode<T> last;

    /**
     * 元素个数
     */
    private int size;

    /**
     * 插入到头部
     * @param data
     */
    public void insertToHead(T data) {
        DuLinkedNode<T> newNode = new DuLinkedNode<>(data);
        insertToHead(newNode);
    }

    /**
     * 插入到头部
     * @param newNode
     */
    public void insertToHead(DuLinkedNode<T> newNode) {

        size++;
    }

}
