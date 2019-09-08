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
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int l, int r) {
        if(l == r) {
            return;
        }
        // 除以2
        int mid = l + ((r - l) >> 1);
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = 0;
        int p1 = l;
        int p2 = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while (p1 <= mid && p2 <= r) {
            temp[i++] = arr[p1] < arr[p2] ? arr[p1++] : arr[p2++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while (p1 <= mid) {
            temp[i++] = arr[p1++];
        }
        while (p2 <= r) {
            temp[i++] = arr[p2++];
        }
        // 把最终的排序的结果复制给原数组
        for (i = 0; i < temp.length; i++) {
            arr[l + i] = temp[i];
        }
    }

}
