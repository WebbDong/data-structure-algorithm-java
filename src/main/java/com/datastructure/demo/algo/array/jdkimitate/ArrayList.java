package com.datastructure.demo.algo.array.jdkimitate;

import java.util.Arrays;
import java.util.Objects;

/**
 * 模仿jdk ArrayList
 * @param <E>
 */
public class ArrayList<E> implements List<E> {

    private static final Object[] EMPTY_ELEMENTDATA = {};

    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};

    private static final int DEFAULT_CAPACITY = 10;

    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 数据
     */
    private E[] elementData;

    /**
     * 实际元素个数
     */
    private int size;

    /**
     *
     */
    public ArrayList() {
        this.elementData = (E[]) DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    /**
     *
     * @param initialCapacity
     */
    public ArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = (E[]) new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = (E[]) EMPTY_ELEMENTDATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    @Override
    public void add(int index, E e) {
        rangeCheckForAdd(index);
        ensureCapacityInternal(size + 1);
        // 以index指定的位置的元素为起始点，将后面的所有元素向后移动一位
        System.arraycopy(elementData, index, elementData, index + 1, size - index);
        elementData[index] = e;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    @Override
    public boolean addAll(List<? extends E> c) {
        return false;
    }

    @Override
    public E set(int index, E e) {
        rangeCheck(index);
        E oldValue = elementData[index];
        elementData[index] = e;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementData[index];
        fastRemove(index);
        return oldValue;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elementData[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            // 移位
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
    }

    @Override
    public boolean removeAll(List<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, false);
    }

    @Override
    public boolean retainAll(List<?> c) {
        Objects.requireNonNull(c);
        return batchRemove(c, true);
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        }
        System.arraycopy(elementData, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    /**
     * 批量删除
     * @param c
     * @param complement
     * @return 当原数组元素个数发生了变化时返回true，否则返回false
     */
    private boolean batchRemove(List<?> c, boolean complement) {
        final E[] elementData = this.elementData;
        int r = 0, w = 0;
        boolean modified = false;
        try {
            for (; r < size; r++) {
                if (c.contains(elementData[r]) == complement) {
                    elementData[w++] = elementData[r];
                }
            }
        } finally {
            // 如果contains方法抛出异常，将中断后的剩下元素进行复制
            if (r != size) {
                System.arraycopy(elementData, r, elementData, w, size - r);
                w += size - r;
            }

            // 将移位后的多余数据置为null
            if (w != size) {
                for (int i = w; i < size; i++) {
                    elementData[i] = null;
                }
                size = w;
                modified = true;
            }
        }
        return modified;
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
    public List<E> subList(int fromIndex, int toIndex) {
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

    private int calculateCapacity(E[] elementData, int minCapacity) {
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

    /**
     * 扩容数组
     * @param minCapacity
     */
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
/*        int[] arr = {
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
        System.out.println("total：" + list.size());
        System.out.println();

        List<Integer> removeList = new ArrayList<>();
        removeList.add(89);
        removeList.add(90);
        removeList.add(91);
        removeList.add(92);
        removeList.add(93);
        removeList.add(94);
        removeList.add(95);
        removeList.add(96);
        removeList.add(97);
        removeList.add(98);
        removeList.add(99);
        removeList.add(100);
        list.removeAll(removeList);
        System.out.println("---------------------------------------");
        printAll(list);
        System.out.println("total：" + list.size());

        System.out.println("---------------------------------------");
        List<Integer> retainList = new ArrayList<>();
        retainList.add(85);
        retainList.add(86);
        retainList.add(87);
        retainList.add(88);
        list.retainAll(retainList);
        printAll(list);
        System.out.println("total：" + list.size());
        System.out.println("---------------------------------------");

        Object[] arr = list.toArray();
        System.out.println(Arrays.toString(arr));

        System.out.println("---------------------------------------");
        Integer[] integerArr = new Integer[20];
        list.toArray(integerArr);
        System.out.println(Arrays.toString(integerArr));
    }

    private static void printAll(List<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
        System.out.println("---------------------------------------");
    }

}
