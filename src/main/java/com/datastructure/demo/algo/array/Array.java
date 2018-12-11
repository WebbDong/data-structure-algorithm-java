package com.datastructure.demo.algo.array;

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

    /**
     * 数据
     */
    private int[] datas;

    /**
     * 元素实际个数
     */
    private int size;

    /**
     * 构造方法
     * @param capacity 数组的初始大小
     */
    public Array(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }
        this.datas = new int[capacity];
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
     * 插入到指定位置
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value) {
        rangeCheckForInsert(index);
        if (size == datas.length) {
            throw new RuntimeException("没有可插入的位置");
        }
        // 在index位置之后的元素全部向后移动一位
        for (int i = size; i > index; i--) {
            datas[i] = datas[i - 1];
        }
        datas[index] = value;
        size++;
        return true;
    }

    /**
     * 添加元素
     * @param value
     * @return
     */
    public boolean add(int value) {
        if (size == datas.length) {
            throw new RuntimeException("没有可插入的位置");
        }
        datas[size++] = value;
        return true;
    }

    /**
     * 删除指定元素
     * @param index
     * @return
     */
    public boolean remove(int index) {
        rangeCheckForDelete(index);
        for (int i = index; i < size - 1; i++) {
            datas[i] = datas[i + 1];
        }
        size--;
        return true;
    }

    /**
     * 数组大小
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 打印所有
     */
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(datas[i] + " ");
        }
        System.out.println();
        System.out.println("-------------------------------");
    }

    /**
     * 检查
     * @param index
     */
    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
    }

    /**
     * 插入检查
     * @param index
     */
    private void rangeCheckForInsert(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
    }

    /**
     * 删除检查
     * @param index
     */
    private void rangeCheckForDelete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index:" + index);
        }
    }

    public static void main(String[] args) {
        Array array = new Array(10);
        for (int i = 0; i < 8; i++) {
            array.add(i);
        }
        array.printAll();
        array.insert(2, 100);
        array.printAll();
        System.out.println(array.get(2));
        System.out.println("--------------------------");
        array.remove(2);
        array.printAll();
        array.remove(4);
        array.printAll();

        /*List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(2, 5);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }*/
    }

}
