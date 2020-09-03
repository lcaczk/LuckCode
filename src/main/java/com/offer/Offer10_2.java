package com.offer;

/**
 * 题目：剑指 Offer 10- II.青蛙跳台阶问题
 * 题目链接：https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
 * 标签：递归
 * <p>
 * 题目描述：
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入：n = 2
 * 输出：2
 * 示例 2：
 * 输入：n = 7
 * 输出：21
 * 示例 3：
 * 输入：n = 0
 * 输出：1
 * <p>
 * 提示：
 * 0 <= n <= 100
 * <p>
 * 注意：本题与主站 70 题相同：https://leetcode-cn.com/problems/climbing-stairs/
 */
class Offer10_2 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int t1 = 1;
        int t2 = 1;
        for (int i = 1; i < n; i++) {
            int tmp = t2;
            t2 = (t1 + t2) % 1000000007;
            t1 = tmp;
        }
        return t2;
    }

    public static void main(String[] args) {
        Offer10_2 solution = new Offer10_2();
        System.out.println(solution.numWays(0));
        System.out.println(solution.numWays(1));
        System.out.println(solution.numWays(2));
        System.out.println(solution.numWays(3));
        System.out.println(solution.numWays(4));
        System.out.println(solution.numWays(5));
        System.out.println(solution.numWays(6));
        System.out.println(solution.numWays(7));
    }
}