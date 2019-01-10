package com.datastructure.demo.algo.linkedlist.model;

/**
 * @Description:    普通单向链表节点
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
public class NormalNode<T extends Comparable<T>> {

    /**
     * 数据元素
     */
    private T data;

    /**
     * 下一个节点
     */
    private NormalNode<T> next;

    public NormalNode() {
    }

    public NormalNode(T data) {
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

    public NormalNode<T> getNext() {
        return next;
    }

    public void setNext(NormalNode<T> next) {
        this.next = next;
    }

}
