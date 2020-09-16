package com.offer;

/**
 * 题目：剑指 Offer 16.数值的整数次方
 * 题目链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
 * 标签：递归
 * <p>
 * 题目描述：
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。
 * 不得使用库函数，同时不需要考虑大数问题。
 * <p>
 * 示例 1:
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2^-2 = 1/2^2 = 1/4 = 0.25
 * <p>
 * 说明:
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]
 * <p>
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 */
class Offer16 {
    public double myPow(double x, int n) {
        // 0特殊判断
        if (x == 0) {
            return 0;
        }
        long b = n;
        // 指数为负数
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        double res = 1.0;
        // 快速幂
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}