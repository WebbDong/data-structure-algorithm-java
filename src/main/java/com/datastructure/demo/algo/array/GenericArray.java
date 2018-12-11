package com.datastructure.demo.algo.array;

/**
 * 范型数组
 * @param <T>
 */
public class GenericArray<T> {

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final Object[] EMPTY_ELEMENTDATA = {};

    /**
     * 数据
     */
    private T[] elementData;

    /**
     * 实际的元素个数
     */
    private int size;

    /**
     * 默认空数组
     */
    public GenericArray() {
        this.elementData = (T[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     * 指定大小
     * @param initialCapacity 数组初始化大小
     */
    public GenericArray(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (T[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    /**
     * 是否是空数组
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 元素个数
     * @return
     */
    public int size() {
        return size;
    }

    /**
     * 添加元素到末尾
     * @param e
     * @return
     */
    public boolean add(T e) {
        dilatation();
        elementData[size++] = e;
        return true;
    }

    /**
     * 添加新元素到指定位置
     * @param index
     * @param e
     */
    public void add(int index, T e) {
        rangeCheckForAdd(index);
        dilatation();
        for (int i = size; i > index; i--) {
            elementData[i] = elementData[i - 1];
        }
        elementData[index] = e;
        size++;
    }

    /**
     * 删除指定的元素，返回旧值
     * @param index
     * @return
     */
    public T remove(int index) {
        rangeCheck(index);
        T oldElement = elementData[index];
        for (int i = index; i < size - 1; i++) {
            elementData[i] = elementData[i + 1];
        }
        elementData[--size] = null;
        shrinkage();
        return oldElement;
    }

    /**
     * 获取指定元素
     * @param index
     * @return
     */
    public T get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    /**
     * 设置指定位置的元素值，并且返回旧值
     * @param index
     * @param e
     * @return
     */
    public T set(int index, T e) {
        rangeCheck(index);
        T oldElement = elementData[index];
        elementData[index] = e;
        return oldElement;
    }

    /**
     * 是否包含某个元素
     * @param o
     * @return
     */
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    /**
     * 从头部开始，查找元素所在的位置，找到返回数组角标，未找到返回-1
     * @param o
     * @return
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 从尾部开始，查找元素所在的位置
     * @param o
     * @return
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = size - 1; i >= 0; i--) {
                if (elementData[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= 0; i--) {
                if (o.equals(elementData[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 打印所有元素
     */
    public void printAll() {
        for (int i = 0; i < size; i++) {
            System.out.print(elementData[i] + " ");
        }
        System.out.println();
        System.out.println("--------------------------------------------------------------");
    }

    /**
     * 扩容，新建数组，for循环复制方式
     */
    private void dilatation() {
        if (size == elementData.length) {
            int capacity = 2 * elementData.length;
            capacity = (capacity <= 0 ? 1 : capacity);
            resize(capacity);
        }
    }

    /**
     * 缩容，新建数组，for循环复制方式<br />
     * 当当前size等于数组大小的四分之一的时候，进行缩容二分之一
     */
    private void shrinkage() {
        if (size == elementData.length / 4 && elementData.length / 2 != 0) {
            int capacity = elementData.length / 2;
            resize(capacity);
        }
    }

    /**
     * 调整大小
     * @param capacity
     */
    private void resize(int capacity) {
        T[] newData = (T[]) new Object[capacity];
        for (int i = 0; i < elementData.length; i++) {
            newData[i] = elementData[i];
        }
        elementData = newData;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    public static void main(String[] args) {
        GenericArray<Integer> array = new GenericArray<>(0);
        for (int i = 1; i <= 30; i++) {
            array.add(i);
        }
        array.printAll();
        System.out.println(array.get(10));
        System.out.println("--------------------------------------------------------------");
        System.out.println("size:" + array.size());
        System.out.println("isEmpty:" + array.isEmpty());
        System.out.println("--------------------------------------------------------------");
        array.add(9, 100);
        array.add(15, 9000);
        array.printAll();
        array.set(3, 50);
        array.printAll();
        System.out.println("--------------------------------------------------------------");
        System.out.println("contans:" + array.contains(23345));
        System.out.println("--------------------------------------------------------------");
        Integer oldValue = array.remove(3);
        System.out.println("oldValue:" + oldValue);
        System.out.println("indexOf:" + array.indexOf(9000));
        System.out.println("lastIndexOf:" + array.lastIndexOf(27));
        array.printAll();
    }

}
