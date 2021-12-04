package com.wkk.interview.bytedance2021.tree;

/**
 * 不同的二叉搜索树
 * @author weikunkun
 * @since 2021/4/3
 */
public class LC_96 {
    public int numTrees(int n) {
        if (n <1) {
            return 0;
        }
        int[] g = new int[n+1];
        g[0] = 1;
        g[1] = 1;
        for (int i = 2; i <= n; i++) {
            for(int j = 1; j <=i; j++) {
                g[i] += g[i-j] * g[j-1];
            }
        }
        return g[n];

    }
}
