package com.datastructure.demo.algo.recursion;

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

    public static int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return f(n - 1) + f(n - 2);
    }

    public static void main(String[] args) {
        System.out.println(f(4) + "种走法");
    }

}
