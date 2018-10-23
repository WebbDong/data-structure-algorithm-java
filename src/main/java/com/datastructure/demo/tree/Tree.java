package com.datastructure.demo.tree;

/**
 * 树
 * @param <T>
 */
public interface Tree<T extends Comparable> {

    /**
     * 查找
     * @param data
     * @return
     */
    TreeNode find(T data);

    /**
     * 插入
     * @param data
     * @return
     */
    boolean insert(T data);

    /**
     * 删除
     * @param data
     * @return
     */
    boolean delete(T data);

    /**
     * 遍历打印
     */
    void traversePrint();

}
