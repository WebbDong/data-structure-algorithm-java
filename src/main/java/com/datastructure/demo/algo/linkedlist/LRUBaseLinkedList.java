package com.datastructure.demo.algo.linkedlist;

import com.datastructure.demo.algo.linkedlist.model.NormalNode;

/**
 * @Description: 基于链表的最近最少使用策略LRU(Least Recently Used)
 * 维护一个有序单链表，越靠近链表尾部的结点是越早之前访问的。当有一个新的数据被访问时，我们从链表头开始顺序遍历
 *   1、如果此数据之前已经被缓存在链表中了，我们遍历得到这个数据对应的结点，并将其从原来的位置删除，然后再插入到链表的头部。
 *   2、如果次2数据没有再缓存链表中，又分为2种情况
 *      a：如果此时缓存未满，则将此结点直接插入到链表的头部；
 *      b：如果此时缓存已满，则链表尾结点删除，将新的数据结点插入链表的头部；
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
        this.head = null;
        this.capacity = DEFAULT_CAPACITY;
        this.size = 0;
    }

}
