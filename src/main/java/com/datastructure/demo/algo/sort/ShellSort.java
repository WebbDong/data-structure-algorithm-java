package com.datastructure.demo.algo.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 1, 3, 2};
        shellSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {6, 5, 4, 3, 2, 1};
        shellSort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

    /**
     * 希尔排序
     * @param arr
     */
    private static void shellSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }
        // 间距
        int h = len / 2;
        while (h >= 1) {
        }
    }

}
