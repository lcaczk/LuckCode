package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class 最优二叉树II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            int ans = Integer.MAX_VALUE;
            int[][][] memo = new int[n + 1][n + 1][n + 1];
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, dfs(nums, 0, i - 1, i, memo) + dfs(nums, i + 1, n - 1, i, memo));
            }
            System.out.print(ans);
        }
    }

    public static int dfs(int[] nums, int l, int r, int father, int[][][] memo) {
        if (l > r) {
            return 0;
        }
        if (l == r) {
            return nums[l] * nums[father];
        }
        if (memo[l][r][father] != 0) {
            return memo[l][r][father];
        }
        int res = Integer.MAX_VALUE;
        for (int i = l; i <= r; i++) {
            int left = dfs(nums, l, i - 1, i, memo);
            int right = dfs(nums, i + 1, r, i, memo);
            res = Math.min(res, left + right + nums[i] * nums[father]);
        }
        memo[l][r][father] = res;
        return res;
    }

}
