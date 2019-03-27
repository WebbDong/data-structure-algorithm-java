package com.datastructure.demo.algo.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr1 = {9, 8, 6, 4, 3, 2, 1};
        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));

//        int[] arr2 = {1, 2, 3, 4, 6, 8, 9};
        int[] arr2 = {9, 8, 6, 4, 3, 2, 1};
        bubbleSortOptimizing(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 冒泡
     * @param arr
     */
    private static void bubbleSort(int[] arr) {
        for (int i = 0, length = arr.length; i < length; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     * @param arr
     */
    private static void bubbleSortOptimizing(int[] arr) {
        for (int i = 0, length = arr.length; i < length; i++) {
            // 每一次冒泡结束后，如果没有交换就代表已经是有序了，结束循环
            boolean isExChanged = false;
            for (int j = 0; j < length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    isExChanged = true;
                }
            }
            if (!isExChanged) {
                break;
            }
        }
    }

}
