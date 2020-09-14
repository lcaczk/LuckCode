package com.offer;

/**
 * 题目：剑指 Offer 14- II.剪绳子 II
 * 题目链接：https://leetcode-cn.com/problems/jian-sheng-zi-ii-lcof/
 * 标签：数学 动态规划
 * <p>
 * 题目描述：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1]。
 * 请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * <p>
 * 提示：
 * 2 <= n <= 1000
 * <p>
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
class Offer14_2 {

    public int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        // 循环求余
        long res = 1;
        while (n > 4) {
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n % 1000000007);
    }

    public int cuttingRope2(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int p = 1000000007;
        int b = n % 3;
        // 快速幂求余
        long res = 1;
        long x = 3;
        for (int a = n / 3 - 1; a > 0; a /= 2) {
            if (a % 2 == 1) {
                res = (res * x) % p;
            }
            x = (x * x) % p;
        }

        if (b == 2) {
            return (int) (2 * res * 3 % p);
        }
        if (b == 0) {
            return (int) (res * 3 % p);
        }
        return (int) (res * 4 % p);
    }

    public static void main(String[] args) {
        Offer14_2 solution = new Offer14_2();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(3));
        System.out.println(solution.cuttingRope(4));
        System.out.println(solution.cuttingRope(8));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope(10));
        // 703522804
        System.out.println(solution.cuttingRope(100));
        System.out.println(solution.cuttingRope2(100));
    }
}
