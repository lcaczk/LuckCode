package com.offer;

/**
 * 题目：剑指 Offer 14- I.剪绳子
 * 题目链接：https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
 * 标签：数学 动态规划
 * <p>
 * 题目描述：
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。
 * 请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 示例 1：
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1
 * 示例 2:
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
 * 提示：
 * 2 <= n <= 58
 * <p>
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 */
class Offer14_1 {
    /**
     * 找规律解法：
     * //   n       max     表达式     1的个数    2的个数    3的个数    4的个数
     * //   2       1       1*1         2           0       0       0        -特殊
     * //   3       2       1*2         1           1       0       0        -特殊
     * //   4       4       2*2         0           2       0       0        -特殊
     * //   5       6       2*3         0           1       1       0        -
     * //   6       9       3*3         0           0       2       0         -三个一组
     * //   7       12      3*4         0           0       1       1        -
     * //   8       18      2*3*3       0           1       2       0        -
     * //   9       27      3*3*3       0           0       3       0         -三个一组
     * //   10      36      3*3*4       0           0       2       1        -
     * <p>
     * 数学推导题解：
     * https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/mian-shi-ti-14-i-jian-sheng-zi-tan-xin-si-xiang-by/
     */
    public int cuttingRope(int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        if (n == 4) {
            return 4;
        }
        if (n % 3 == 2) {
            return (int) (2 * Math.pow(3, n / 3));
        }
        if (n % 3 == 0) {
            return (int) Math.pow(3, n / 3);
        }
        if (n % 3 == 1) {
            return (int) Math.pow(3, n / 3 - 1) * 4;
        }
        return -1;
    }


    /**
     * 动态规划：
     * 把长度为i的绳子拆成两部分，一部分是j，另一部分是i-j，会有4种情况：
     * 1. j和i-j都不能再拆了
     * dp[i] = j * (i-j);
     * 2. j能拆，i-j不能拆
     * dp[i] = dp[j] * (i-j);
     * 3. j不能拆，i-j能拆
     * dp[i] = j * dp[i-j];
     * 4. j和i-j都能拆
     * dp[i] = dp[j] * dp[i-j];
     * 取上面4种情况的最大值：
     * dp[i] = max(dp[i], (max(j, dp[j])) * (max(i - j, dp[i - j])));
     */
    public int cuttingRope2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 循环体中写i/2是为了减少计算次数（因为比如1x3和3x1值是一样的，计算一次即可）
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], (Math.max(j, dp[j]) * Math.max(i - j, dp[i - j])));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Offer14_1 solution = new Offer14_1();
        System.out.println(solution.cuttingRope(2));
        System.out.println(solution.cuttingRope(3));
        System.out.println(solution.cuttingRope(4));
        System.out.println(solution.cuttingRope(5));
        System.out.println(solution.cuttingRope(6));
        System.out.println(solution.cuttingRope(7));
        System.out.println(solution.cuttingRope(8));
        System.out.println(solution.cuttingRope(9));
        System.out.println(solution.cuttingRope(10));
        System.out.println(solution.cuttingRope2(2));
        System.out.println(solution.cuttingRope2(3));
        System.out.println(solution.cuttingRope2(4));
        System.out.println(solution.cuttingRope2(5));
        System.out.println(solution.cuttingRope2(6));
        System.out.println(solution.cuttingRope2(7));
        System.out.println(solution.cuttingRope2(8));
        System.out.println(solution.cuttingRope2(9));
        System.out.println(solution.cuttingRope2(10));
    }
}
