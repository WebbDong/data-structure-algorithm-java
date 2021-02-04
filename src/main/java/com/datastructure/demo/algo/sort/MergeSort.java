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
        int[] arr1 = {90, 100, 300, 9, 5, 1, 500, 400};
        recursionMergeSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    // --------------- 递归方式 -------------------

    /**
     * 递归方式归并排序
     * @param arr
     */
    public static void recursionMergeSort(int[] arr) {
        sort(arr, 0, arr.length);
    }

    public static void sort(int[] arr, int begin, int end) {
        // 如果元素只有一个或者没有元素直接返回
        if (end - begin < 2) {
            return;
        }

        // 除以2
        int mid = (begin + end) >> 1;
        sort(arr, begin, mid);
        sort(arr, mid, end);
        merge();
    }

    private static void merge() {

    }

}
