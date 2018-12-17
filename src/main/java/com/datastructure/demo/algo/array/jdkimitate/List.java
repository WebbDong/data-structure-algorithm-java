package com.datastructure.demo.algo.array.jdkimitate;

/**
 * List接口
 * @param <E>
 */
public interface List<E> {

    /**
     * 添加新元素到指定位置
     * @param index
     * @param e
     */
    void add(int index, E e);

    /**
     * 获取指定位置的元素
     * @param index
     * @return
     */
    E get(int index);

    /**
     * 设置指定位置的元素
     * @param index
     * @param e
     * @return
     */
    E set(int index, E e);

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
    List<E> subList(int fromIndex, int toIndex);

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
    boolean add(E e);

    /**
     * 添加多个元素
     * @param c
     * @return
     */
    boolean addAll(List<? extends E> c);

    /**
     * 删除指定位置的元素
     * @param index
     * @return
     */
    E remove(int index);

    /**
     * 删除指定的元素值
     * @param o
     * @return
     */
    boolean remove(Object o);

    /**
     * 删除多个元素
     * @param c
     * @return 当原数组元素个数发生了变化时返回true，否则返回false
     */
    boolean removeAll(List<?> c);

    /**
     * 取的2个集合的交集元素，当判断2个元素是否有交集时，要调用之后判断size的大小。不为0就表示有交集
     * @param c
     * @return 当原数组元素个数发生了变化时返回true，否则返回false
     */
    boolean retainAll(List<?> c);

    /**
     * 转换成数组
     * @return
     */
    Object[] toArray();

    /**
     * 转换成数组
     * @param a
     * @return
     */
    <T> T[] toArray(T[] a);

    /**
     * 清空所有元素
     */
    void clear();

}
