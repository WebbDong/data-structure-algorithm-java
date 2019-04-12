package com.datastructure.demo.algo.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr1 = {4, 5, 6, 1, 3, 2};
        shellKnuthSort(arr1);
        System.out.println(Arrays.toString(arr1));

        int[] arr2 = {6, 5, 4, 3, 2, 1};
        shellKnuthSort(arr2);
        System.out.println(Arrays.toString(arr2));

        int[] arr3 = {1, 2, 3, 4, 5, 6};
        shellKnuthSort(arr3);
        System.out.println(Arrays.toString(arr3));
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
            for (int i = h; i < len; i++) {
                int value = arr[i];
                int j = i - h;
                for (; j >= 0; j -= h) {
                    if (arr[j] > value) {
                        arr[j + h] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + h] = value;
            }
            h /= 2;
        }
    }

    /**
     * 希尔排序，Knuth增量序列
     * @param arr
     */
    private static void shellKnuthSort(int[] arr) {
        int len = arr.length;
        if (len <= 1) {
            return;
        }
        // Knuth增量序列间距
        int h = 1;
        while (h <= len / 3) {
            h = h * 3 + 1;
        }

        while (h >= 1) {
            for (int i = h; i < len; i++) {
                int value = arr[i];
                int j = i - h;
                for (; j >= 0; j -= h) {
                    if (arr[j] > value) {
                        arr[j + h] = arr[j];
                    } else {
                        break;
                    }
                }
                arr[j + h] = value;
            }
            h = (h - 1) / 3;
        }
    }

}
