package com.datastructure.demo.algo.linkedlist.model;

import lombok.Data;

/**
 * @Description:    单链表节点
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
@Data
public class SinglyNode<T> {

    /**
     * 数据元素
     */
    private T data;

    /**
     * 下一个节点
     */
    private SinglyNode<T> next;

    public SinglyNode(T data) {
        this.data = data;
    }

}
