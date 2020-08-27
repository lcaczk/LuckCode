package com.offer;

/**
 * 题目：剑指 Offer 10- I.斐波那契数列
 * 题目链接：https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
 * 标签：递归
 * <p>
 * 题目描述：
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项。斐波那契数列的定义如下：
 * F(0) = 0, F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：1
 * 示例 2：
 * 输入：n = 5
 * 输出：5
 * <p>
 * 提示：
 * 0 <= n <= 100
 * 注意：本题与主站 509 题相同：https://leetcode-cn.com/problems/fibonacci-number/
 */
class Offer10_1 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int t1 = 0;
        int t2 = 1;
        for (int i = 1; i < n; i++) {
            int tmp = t2;
            // 求和后就取模
            t2 = (t1 + t2) % 1000000007;
            t1 = tmp;
        }
        return t2;
    }

    public static void main(String[] args) {
        Offer10_1 solution = new Offer10_1();
        System.out.println(solution.fib(0));
        System.out.println(solution.fib(1));
        System.out.println(solution.fib(2));
        System.out.println(solution.fib(3));
        System.out.println(solution.fib(4));
        System.out.println(solution.fib(5));
        System.out.println(solution.fib(6));
        // 807526948
        System.out.println(solution.fib(48));
    }
}
