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

    /**
     * 打开页面
     * @param url
     */
    public void open(String url) {
        if (this.currentUrl != null) {
            this.backStack.push(this.currentUrl);
            this.forwardStack.clear();
        }
        this.currentUrl = url;
    }

    /**
     * 后退
     */
    public void goBack() {
        if (this.canGoBack()) {
            this.forwardStack.push(this.currentUrl);
            this.currentUrl = backStack.pop();
        }
    }

    /**
     * 前进
     */
    public void goForward() {
        if (this.canGoForward()) {
            this.backStack.push(this.currentUrl);
            this.currentUrl = forwardStack.pop();
        }
    }

    public void checkCurrentUrl() {
        System.out.println("current url: " + this.currentUrl);
    }

    private boolean canGoBack() {
        return !this.backStack.isEmpty();
    }

    private boolean canGoForward() {
        return !this.forwardStack.isEmpty();
    }

    public static void main(String[] args) {
        Browser browser = new Browser();
        browser.open("http://www.baidu.com");
        browser.open("http://www.tudou.com");
        browser.open("http://www.github.com");
        browser.open("http://www.youku.com");
        browser.checkCurrentUrl();
        browser.goBack();
        browser.checkCurrentUrl();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentUrl();
        browser.goForward();
        browser.checkCurrentUrl();
        browser.goForward();
        browser.checkCurrentUrl();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.checkCurrentUrl();

        browser.goBack();
        browser.goBack();
        browser.checkCurrentUrl();
        browser.open("http://china.nba.com");
        browser.checkCurrentUrl();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentUrl();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.goForward();
        browser.checkCurrentUrl();
    }

}
