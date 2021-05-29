package com.wkk.dp.intervalI;

/**
 * @author weikunkun
 * @since 2021/5/24
 */
public class LC_312 {
    public int maxCoins(int[] nums) {
        // 戳破s[i:j]的所有气球，最大的硬币数量
        // 🪙
        int n = nums.length;
        int[] array = new int[n + 2];
        System.arraycopy(nums, 0, array, 1, n);
        array[0] = 1;
        array[array.length - 1] = 1;
        int[][] dp = new int[n + 2][n + 2];
        for (int len = 1; len <= n; len++) {
            for (int i = 1; i + len - 1 <= n; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k-1] + dp[k+1][j] + array[i-1] * array[k] * array[j+1]);
                }
            }
        }
        return dp[1][n];
    }

    public static void main(String[] args) {
        int[] nums = {3,1,5,8};
        int len = nums.length;
        int[] array = new int[nums.length + 1];
        array[0] = 1;
        System.arraycopy(nums, 0, array, 1, len);
        for (int i : array) {
            System.out.println(i);
        }
    }
}
