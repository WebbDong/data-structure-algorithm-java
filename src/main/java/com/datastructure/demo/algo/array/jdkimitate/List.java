package com.datastructure.demo.algo.array.jdkimitate;

/**
 * List接口
 * @param <T>
 */
public interface List<T> {

    /**
     * 添加新元素到指定位置
     * @param index
     * @param e
     */
    void add(int index, T e);

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    T get(int index);

    /**
     * 设置指定位置的元素
     * @param index
     * @param e
     * @return
     */
    T set(int index, T e);

    /**
     * 从头到尾，查询某个元素的位置
     * @param o
     * @return
     */
    int indexOf(Object o);

    /**
     * 从尾到头，查询某个元素的位置
     * @param o
     * @return
     */
    int lastIndexOf(Object o);

    /**
     * 获取子List
     * @param fromIndex
     * @param toIndex
     * @return
     */
    List<T> subList(int fromIndex, int toIndex);

    /**
     * 元素个数
     * @return
     */
    int size();

    /**
     * 是否为空集合
     * @return
     */
    boolean isEmpty();

    /**
     * 是否包含某个元素
     * @param o
     * @return
     */
    boolean contains(Object o);

    /**
     * 添加元素到末尾
     * @param e
     * @return
     */
    boolean add(T e);

    /**
     * 添加多个元素
     * @param c
     * @return
     */
    boolean addAll(List<? extends T> c);

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    T remove(int index);

    /**
     * 删除指定的元素值
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 删除多个元素
     * @param c
     * @return
     */
    boolean removeAll(List<?> c);

    /**
     * 清空所有元素
     */
    void clear();

}
