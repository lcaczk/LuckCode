package com.wkk.everyday.july;

/**
 * @Time: 2020/7/15上午8:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 0;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}
