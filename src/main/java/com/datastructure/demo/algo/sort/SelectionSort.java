package com.datastructure.demo.algo.sort;

import java.util.Arrays;

/**
 * 选择排序
 * 1、选择排序空间复杂度为O(1)，是原地排序算法
 * 2、最好情况时间复杂度、最坏情况时间复杂度和平均情况时间复杂度都是O(n^2)
 * 3、选择排序是不稳定排序算法
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 1, 3, 2};
        selectionSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {6, 5, 4, 3, 2, 1};
        selectionSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    public static void selectionSort(int[] arr) {
        if (arr == null || arr.length == 0) {
            return;
        }
        for (int i = 0, length = arr.length; i < length; i++) {
            int minIndex = i;
            for (int j = minIndex + 1; j < length; j++) {
                if (arr[minIndex] > arr[j]) {
                    minIndex = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

}
