package com.datastructure.demo.algo.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 实现类似ArrayList，数据类型为int
 * @Author: Webb Dong
 * @CreateDate: 2018/11/19 10:39
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2018/11/19 10:39
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class Array {

    private static final int[] EMPTY_ELEMENTDATA = {};

    /**
     * 数据
     */
    private int[] datas;

    /**
     * 数组的长度
     */
    private int n;

    /**
     * 元素实际个数
     */
    private int size;

    /**
     * 构造方法
     * @param capacity 数组的初始大小
     */
    public Array(int capacity) {
        if (capacity > 0) {
            this.datas = new int[capacity];
        } else if (capacity == 0) {
            this.datas = EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.n = capacity;
        // 刚开始一个元素都没有所以设置为0
        this.size = 0;
    }

    /**
     * 获取指定的元素
     * @param index
     * @return
     */
    public int get(int index) {
        rangeCheck(index);
        return datas[index];
    }

    /**
     * 添加元素
     * @param i
     * @return
     */
    public boolean add(int i) {
        ensureCapacityInternal(size + 1);
        datas[size++] = i;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
//        System.arraycopy();

    }

    /**
     * 数组大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     *
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
    }

    public static void main(String[] args) {
/*        Array array = new Array(10);
        array.add(50);
        array.add(100);
        array.add(150);

        for (int i = 0; i < array.size(); i++) {
            System.out.println(array.get(i));
        }*/

        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(100);
        list.add(200);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
