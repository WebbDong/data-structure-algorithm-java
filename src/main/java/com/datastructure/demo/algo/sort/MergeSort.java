package com.datastructure.demo.algo.sort;

import java.util.Arrays;

/**
 * @Description: 归并排序
 * @Author: Webb Dong
 * @CreateDate: 2019/07/22 13:41
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/07/22 13:41
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {500, 400, 300, 100, 90, 9, 5, 1};
//        recursionMergeSort(arr1);
        iterationMergeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // --------------- 递归方式 -------------------

    /**
     * 备份数组
     */
    private static int[] tempArr;

    /**
     * 递归方式归并排序
     * @param arr
     */
    public static void recursionMergeSort(int[] arr) {
        tempArr = new int[arr.length >> 1];
        divide(arr, 0, arr.length);
    }

    /**
     * 拆分
     * @param arr
     * @param begin
     * @param end
     */
    public static void divide(int[] arr, int begin, int end) {
        // 如果元素只有一个或者没有元素直接返回
        if (end - begin < 2) {
            return;
        }

        // 除以2
        int mid = (begin + end) >> 1;
        divide(arr, begin, mid);
        divide(arr, mid, end);
        merge(arr, begin, mid, end);
    }

    /**
     * 合并
     * @param arr
     * @param begin
     * @param mid
     * @param end
     */
    private static void merge(int[] arr, int begin, int mid, int end) {
        final int le = mid - begin;
        final int re = end;
        int ai = begin;
        int li = 0;
        int ri = mid;

        // 将左半部分的数组元素备份
        for (int i = 0; i < le; i++) {
            tempArr[i] = arr[begin + i];
        }

        // 左半部分遍历结束后，就不需要在比较移动元素
        while (li < le) {
            if (ri < re && arr[ri] < tempArr[li]) {
                arr[ai++] = arr[ri++];
            } else {
                arr[ai++] = tempArr[li++];
            }
        }
    }

    // --------------- 迭代方式 -------------------

    public static void iterationMergeSort(int[] arr1) {
    }

}
