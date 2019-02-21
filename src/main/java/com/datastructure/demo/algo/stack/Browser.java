package com.datastructure.demo.algo.stack;

/**
 * @Description: 简单实现浏览器前进后退
 * @Author: Webb Dong
 * @CreateDate: 2019/02/21 23:13
 * @UpdateUser: Webb Dong
 * @UpdateDate: 2019/02/21 23:13
 * @UpdateRemark:
 * @Version: 1.0.0
 */
public class Browser {

    /**
     * 后退url栈
     */
    private ArrayDilatationStack<String> backStack;

    /**
     * 前进url栈
     */
    private ArrayDilatationStack<String> forwardStack;

    /**
     * 当前url
     */
    private String currentUrl;

    public Browser() {
        backStack = new ArrayDilatationStack<>(5);
        forwardStack = new ArrayDilatationStack<>(5);
    }

    public void open(String url) {
        if (this.currentUrl != null) {
            this.backStack.push(url);
            this.forwardStack.clear();
        }
        this.currentUrl = url;
    }

    public static void main(String[] args) {

    }

}
