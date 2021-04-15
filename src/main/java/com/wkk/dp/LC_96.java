package com.wkk.dp;

/**
 * 不同的二叉搜索树
 *
 * @author weikunkun
 * @since 2021/4/12
 */
public class LC_96 {
    /**
     * 思路：
     * 定义数组和明确下标 dp[i] ：1 - i 为节点构成的二叉搜索树个数
     * 说实话这题知识用到了二叉搜索树的性质，实质是动归
     * 1. 对于数字n，则从1-n依次枚举为跟节点
     *  1.1 减去一个值后，还剩余n-1个节点 可以随机的分配到根节点的左右
     *      左边：1 右边 n-1-1
     *      左边：2 右边 n-1-2
     *      左边：3 右边 n-1-3
     *      ...
     *      左边 n-1-2 右边 2
     *  1.2 抽象点儿 当前遍历到k为跟节点
     *      左边 k-1 右边 n-k
     *      则左边可以构成 dp[k-1]二叉搜索树   右边可以构成 dp[n-k]个二叉搜索树 之后进行排列组合
     *      所以 当前根构成的二叉搜索树数量：dp[k-1] * dp[n-k]
     *  1.3 通过1.2得知，仅仅是一个根节点情况，那么对于n个跟节点，进行求和即可
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <=i; j++) {
                dp[i] += dp[i-j] * dp[j-1];
            }
        }
        return dp[n];
    }
}