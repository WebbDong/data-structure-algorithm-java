package com.datastructure.demo.algo.linkedlist.model;

/**
 * @Description:    双向链表节点
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
public class DuLinkedNode<T> {

    /**
     * 数据元素
     */
    private T data;

    /**
     * 上一个节点
     */
    private DuLinkedNode<T> previous;

    /**
     * 下一个节点
     */
    private DuLinkedNode<T> next;

    public DuLinkedNode() {
    }

    public DuLinkedNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "data=" + data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public DuLinkedNode<T> getPrevious() {
        return previous;
    }

    public void setPrevious(DuLinkedNode<T> previous) {
        this.previous = previous;
    }

    public DuLinkedNode<T> getNext() {
        return next;
    }

    public void setNext(DuLinkedNode<T> next) {
        this.next = next;
    }

}
