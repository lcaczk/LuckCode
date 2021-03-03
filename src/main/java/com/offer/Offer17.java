package com.offer;

/**
 * 题目：剑指 Offer 17.打印从1到最大的n位数
 * 题目链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
 * 标签：数学
 * <p>
 * 题目描述：
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 示例 1:
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 * <p>
 * 说明：
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
class Offer17 {
    public int[] printNumbers(int n) {
        int maxNum = 9;
        for (int i = 1; i < n; i++) {
            maxNum = maxNum * 10 + 9;
        }
        int[] res = new int[maxNum];
        for (int i = 1; i <= maxNum; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    /**
     * 思路： 题目难点为确定数组的大小。。。
     * @param n
     * @return
     */
    public int[] printNumbersII(int n) {
        if (n < 0) {
            return null;
        }
        return genNumber(n);
    }

    private int[] genNumber(int n) {
        int sum = 1;
        while (n > 0) {
            n--;
            sum *= 10;
        }
        int[] result = new int[sum-1];
        for (int i = 0; i < result.length; i++) {
            result[i] = i + 1;
        }
        return result;
    }
}