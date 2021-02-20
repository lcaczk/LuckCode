package com.wkk.top100.tree.medium;

/**
 * 96 不同的二叉搜索树
 * 思路：
 * 1. 刚开始想的是回溯的问题，但是无法编写是否为二叉搜索树条件
 * 2. 动态规划
 *  2.1 经草稿，发现对于二叉搜索树构成数量而言，不在乎数字是多少，而是在乎数字的个数（前提是有序）
 *  2.2 多画几个发现，其实是有规律可循的
 *  2.3 g(x)：整数n可构成的二叉搜索树为g(x)个
 *  2.4 g(x) = 求和g(i);
 *  2.5 g(i) = g(x-i) * g(i-1)
 * @author weikunkun
 * @since 2021/2/19
 */
public class LC_96 {
    public int numTrees(int n) {
        if (n <1) {
            return 0;
        }
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i < n; i++) {
            for(int j = 1; j <= i; j++) {
                g[i] += g[i-j] * g[j-1];
            }
        }
        return g[n];

    }
}
