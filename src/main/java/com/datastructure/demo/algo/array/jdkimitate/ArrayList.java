package com.datastructure.demo.algo.array.jdkimitate;

import java.util.Arrays;

/**
 * 模仿jdk ArrayList
 * @param <T>
 */
public class ArrayList<T> implements List<T> {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 数据
     */
    private T[] elementData;

    /**
     * 实际元素个数
     */
    private int size;

    /**
     *
     */
    public ArrayList() {
        this.elementData = (T[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     *
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (T[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (T[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    @Override
    public void add(int index, T e) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        // 以index指定的位置的元素为起始点，将后面的所有元素向后移动一位
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    @Override
    public T get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean add(T e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean addAll(List<? extends T> c) {
        return false;
    }

    @Override
    public T set(int index, T e) {
        rangeCheck(index);
        T oldValue = elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    @Override
    public T remove(int index) {
        rangeCheck(index);
        T oldValue = elementData[index];

        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean removeAll(List<?> c) {
        return false;
    }

    @Override
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

    @Override
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

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private int calculateCapacity(T[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - MAX_ARRAY_SIZE > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    public static void main(String[] args) {
        /*int[] arr = {
                1, 2, 3, 4, 5, 6
        };
        int[] newArr = Arrays.copyOf(arr, arr.length);
        System.out.println(Arrays.toString(newArr));
        System.out.println("----------------------------------");

        int[] newArr2 = new int[30];
        System.arraycopy(arr, 0, newArr2, 0, arr.length);
        System.out.println(Arrays.toString(newArr2));


        System.arraycopy(newArr2, 3, newArr2, 3 + 1, 6 - 3);
        System.out.println(Arrays.toString(newArr2));*/


        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            list.add(i);
        }
        printAll(list);
        list.set(2, 5000);
        list.add(10, 9000);
        printAll(list);
        System.out.println();
    }

    private static void printAll(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------");
    }

}
