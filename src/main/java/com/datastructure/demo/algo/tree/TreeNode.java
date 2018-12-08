package com.datastructure.demo.algo.tree;

import lombok.Data;

/**
 * 树节点
 * @param <T>
 */
@Data
public class TreeNode<T> {

    /**
     * 数据
     */
    private T data;

    /**
     * 左子节点
     */
    private TreeNode<T> leftChild;

    /**
     * 右子节点
     */
    private TreeNode<T> rightChild;

    public TreeNode() {

    }

    public TreeNode(T data) {
        this.data = data;
    }

}
