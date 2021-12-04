package com.wkk.dp.timeSequences;

/**
 * @author weikunkun
 * @since 2021/6/25
 */
public class LC_1388 {
    public int maxSizeSlices(int[] slices) {
        if (slices == null || slices.length == 0) return 0;
        if (slices.length == 1) return slices[0];
        if (slices.length == 2) return Math.max(slices[0], slices[1]);

        int len = slices.length;
        int n = len / 3;
        return Math.max(maxTakebyRange(slices, 0, len - 2, n), maxTakebyRange(slices, 1, len - 1, n));

    }

    private int maxTakebyRange(int[] slices, int start, int end, int n) {
        if (start == end) return slices[start];
        int len = end - start + 1;

        //dp[i][j] = the max size we can get, range: [0, i], picked count: j
        int[][] dp = new int[len][n + 1];

        //base condition
        dp[0][0] = 0;
        dp[0][1] = slices[start];
        dp[1][0] = 0;
        dp[1][1] = Math.max(slices[start], slices[start + 1]);

        //dp transfer
        for (int i = 2; i < len; i++) {
            for (int j = 1; j <= n; j++) {
                dp[i][j] = Math.max(dp[i - 2][j - 1] + slices[start + i], dp[i - 1][j]);
            }
        }

        return dp[len - 1][n];
    }
}
