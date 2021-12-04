package com.wkk.dfs;

/**
 * @author weikunkun
 * @since 2021/11/19
 */
public class LC_397 {
    public int integerReplacement(int n) {
        long nums = n;
        return dfs(nums);
    }

    private int dfs(long n) {
        if (n == 1) {
            return 0;
        }
        if (n % 2 == 0) {
            return dfs(n / 2) + 1;
        }
        
        return Math.min(dfs(n + 1), dfs(n - 1)) + 1;
    }

    public static void main(String[] args) {
        int n = Integer.MAX_VALUE;
        LC_397 lc_397 = new LC_397();
        lc_397.integerReplacement(n);
    }
}
