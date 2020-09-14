package com.offer;

/**
 * 题目：剑指 Offer 15.二进制中1的个数
 * 题目链接：https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/
 * 标签：位运算
 * <p>
 * 题目描述：
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。
 * 例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出2。
 * <p>
 * 示例 1：
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 * 示例 2：
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 * 示例 3：
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class Offer15_1 {
    public int hammingWeight(int n) {
        int res = 0;
        while (n != 0) {
            res += n & 1;
            n = n >>> 1;
        }
        return res;
    }

    public int hammingWeight2(int n) {
        int res = 0;
        while (n != 0) {
            // (n−1) ： 二进制数字 n 最右边的 1 变成 0 ，此 1 右边的 0 都变成 1 。
            // n&(n−1) ： 二进制数字 n 最右边的 1 变成 0 ，其余不变。
            res++;
            n &= n - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Offer15_1 solution = new Offer15_1();
        System.out.println(solution.hammingWeight(2));
        System.out.println(solution.hammingWeight(3));
        System.out.println(solution.hammingWeight(11));
    }
}