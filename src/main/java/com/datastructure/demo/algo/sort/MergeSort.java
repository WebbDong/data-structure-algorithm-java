package com.datastructure.demo.algo.sort;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * 归并排序
 *      1、基于分治思想，先拆分再合并
 *      2、稳定的排序算法
 *      3、最好情况、最坏情况，平均情况，时间复杂度都是 O(nlogn)
 *      4、空间复杂度 O(nlogn)，所以不是原地排序算法
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr1 = {500, 400, 300, 100, 0, 90, 9, 5, 1, 600};
        recursionMergeSort(arr1);
//        iterationMergeSort(arr1);
//        forkJoinMergeSort(arr1);
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
    private static void divide(int[] arr, int begin, int end) {
        // 如果元素只有一个或者没有元素直接返回
        if (end - begin < 2) {
            return;
        }

        // 除以2，将数组分割成两半
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

    public static void iterationMergeSort(int[] arr) {
    }



    // --------------- 使用 ForkJoin 方式 -------------------

    @Data
    @AllArgsConstructor
    private static class MergeSortTask extends RecursiveTask<int[]> {

        private int[] arr;

        private int begin;

        private int end;

        @Override
        protected int[] compute() {
            if (end - begin < 2) {
                return arr;
            } else {
                int mid = (end + begin) >> 1;
                MergeSortTask task1 = new MergeSortTask(arr, begin, mid);
                MergeSortTask task2 = new MergeSortTask(arr, mid, end);
                task1.fork();
                task2.compute();
                task1.join();
                merge(arr, begin, mid, end);
            }
            return arr;
        }

    }

    public static void forkJoinMergeSort(int[] arr) {
        tempArr = new int[arr.length >> 1];
        final ForkJoinPool fjp = new ForkJoinPool();
        final MergeSortTask task = new MergeSortTask(arr, 0, arr.length);
        fjp.execute(task);
        task.join();
        fjp.shutdown();
    }

}
