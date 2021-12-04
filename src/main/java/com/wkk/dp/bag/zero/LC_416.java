package com.wkk.dp.bag.zero;

import java.util.Arrays;

/**
 * 分割和子集
 * 思路： 0/1背包问题
 *
 * @author weikunkun
 * @since 2021/4/28
 */
public class LC_416 {
    public boolean canPartition(int[] nums) {
        // 抽象
        // 能否从数组中挑选若干个元素，使得元素总和等于所有元素总和的一半
        // 我们背包容量为 ，每个数组元素的「价值」与「成本」都是其数值大小，求我们能否装满背包。
        // dp[i][j] 前i个数值，其选择数字总合不超过j的最大价值
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int half = (sum >> 1);
        if (half * 2 != sum) {
            return false;
        }
        int[][] dp = new int[n][half + 1];
        for (int i = 0; i <= half; i++) {
            dp[0][i] = i >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= half; j++) {
                int x = dp[i - 1][j];
                int y = j >= nums[i] ? dp[i - 1][j - nums[i]] + nums[i] : 0;
                dp[i][j] = Math.max(x, y);
            }
        }
        return dp[n - 1][half] == half;

    }

    public boolean canPartitionII(int[] nums) {
        int n = nums.length;
        int sum = Arrays.stream(nums).sum();
        int target = sum / 2;
        if (target * 2 != sum) {
            return false;
        }
        boolean[][] dp = new boolean[n + 1][target + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                boolean no = dp[i - 1][j];
                boolean yes = j >= nums[i] ? dp[i - 1][j - nums[i]] : false;
                dp[i][j] = yes | no;
            }
        }
        return dp[n - 1][target];

    }

    public boolean canPartitionIII(int[] nums) {
        int total =  Arrays.stream(nums).sum();
        int avg = total / 2;
        if (total % 2 != 0) {
            return false;
        }
        return cal(avg, nums);
    }

    private boolean cal(int target, int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][target + 1];
        // 初始化
        // dp[i][0] = 0;
        // dp[0][i] =
        for (int i = 0; i <= target; i++) {
            dp[0][i] = i >= nums[0] ? nums[0] : 0;
        }

        for (int i = 1; i <= n; i++) { //物品
            for (int j = 1; j <= target; j++) { // 背包容量
                int no = dp[i-1][j];
                int yes = j >= nums[i - 1] ? dp[i-1][j - nums[i - 1]] + nums[i - 1] : 0;
                dp[i][j] = Math.max(no, yes);
            }
        }
        return dp[n][target] == target;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 5};
        LC_416 lc_416 = new LC_416();
        System.out.println(lc_416.canPartitionIII(arr));
    }
}
