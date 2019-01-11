package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 基于链表的LRU()
* @Author: Webb Dong
 * @CreateDate: 2019/01/11 16:56
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/01/11 16:56
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class LRUBaseLinkedList<T extends Comparable<T>> {

    /**
     * 默认链表容量
     */
    private final static int DEFAULT_CAPACITY = 10;

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

    public LRUBaseLinkedList() {
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

}
