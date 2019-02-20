package com.datastructure.demo.algo.stack;

/**
 * @Description: 基于数组的动态扩容顺序栈
 * @Author: Webb Dong
 * @CreateDate: 2019/02/19 18:23
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/19 18:23
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class ArrayDilatationStack<T> {

    /**
     * 数组
     */
    private T[] elements;

    /**
     * 元素个数
     */
    private int count;

    /**
     * 栈大小
     */
    private int capacity;

    public int getCount() {
        return count;
    }

    public ArrayDilatationStack(int capacity) {
        this.elements = (T[]) new Object[capacity];
        this.count = 0;
        this.capacity = capacity;
    }

    /**
     * 入栈
     * @param element
     * @return
     */
    public boolean push(T element) {
        dilatation();
        this.elements[count++] = element;
        return true;
    }

    /**
     * 弹栈
     * @return
     */
    public T pop() {
        if (count == 0) {
            return null;
        }

        T element = this.elements[--count];
        this.elements[count] = null;
        return element;
    }

    /**
     * 获取栈顶元素，不弹栈
     * @return
     */
    public T peek() {
        if (count == 0) {
            return null;
        }

        return this.elements[count - 1];
    }

    /**
     * 扩容
     */
    private void dilatation() {
        if (count == capacity) {
            int newCapacity = capacity * 2;
            resize(newCapacity);
        }
    }

    /**
     * 调整大小
     * @param newCapacity
     */
    private void resize(int newCapacity) {
        T[] newElements = (T[]) new Object[newCapacity];
        for (int i = 0; i < count; i++) {
            newElements[i] = this.elements[i];
        }
        this.capacity = newCapacity;
        this.elements = newElements;
    }

    public static void main(String[] args) {
        ArrayDilatationStack<Integer> stack = new ArrayDilatationStack<>(5);

        for (int i = 0; i < 20; i++) {
            stack.push(i);
        }

        System.out.println("stack.getCount()=" + stack.getCount());

        for (int i = 0, count = stack.getCount(); i < count; i++) {
            System.out.println(stack.pop());
        }
    }

}
