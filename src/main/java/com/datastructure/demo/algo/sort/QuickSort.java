package com.datastructure.demo.algo.sort;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {8, 10, 2, 3, 6, 1, 5};
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int p, int r) {
        if (p >= r) {
            return;
        }
    }

}
