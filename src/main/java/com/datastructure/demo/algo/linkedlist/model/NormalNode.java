package com.datastructure.demo.algo.linkedlist.model;

import lombok.Data;

/**
 * @Description:    普通单向链表节点
 * @Author:         Webb Dong
 * @CreateDate:     2018/12/24 16:35
 * @UpdateUser:     Webb Dong
 * @UpdateDate:     2018/12/24 16:35
 * @UpdateRemark:
 * @Version:        1.0.0
 */
@Data
public class NormalNode<T> {

    /**
     * 数据元素
     */
    private T data;

    /**
     * 下一个节点
     */
    private NormalNode<T> next;

    public NormalNode(T data) {
        this.data = data;
    }

}
