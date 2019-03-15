package com.datastructure.demo.algo.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * 假如这里有 n 个台阶，每次你可以跨 1 个台阶或者 2 个台阶，请问走这 n 个台阶有多少种走法？
 * 如果有 7 个台阶，你可以 2，2，2，1 这样子上去，也可以 1，2，1，1，2 这样子上去，总之走法有很多，
 * 那如何用编程求得总共有多少种走法呢？
 * @Author: Webb Dong
 * @CreateDate: 2019/03/05 23:55
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/03/05 23:55
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class Step {

    private static final Map<Integer, Integer> CACHE_MAP = new HashMap<>();

    /**
     * 普通做法
     * @param n
     * @return
     */
    public static int normal(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return normal(n - 1) + normal(n - 2);
    }

    /**
     * 去除重复计算
     * @param n
     * @return
     */
    public static int noRepeatedCalculation(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        if (CACHE_MAP.containsKey(n)) {
            return CACHE_MAP.get(n);
        }

        int res = noRepeatedCalculation(n - 1) + normal(n - 2);
        CACHE_MAP.put(n, res);
        return res;
    }

    /**
     * 去除递归
     * @param n
     * @return
     */
    public static int noRecursion(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int ret = 0;
        int pre = 2;
        int prepre = 1;
        for (int i = 3; i <= n; i++) {
            ret = pre + prepre;
            prepre = pre;
            pre = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(normal(25) + "种走法");
        System.out.println(noRepeatedCalculation(25) + "种走法");
        System.out.println(noRecursion(25) + "种走法");
    }

}
