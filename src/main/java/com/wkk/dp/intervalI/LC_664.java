package com.wkk.dp.intervalI;

/**
 * @author weikunkun
 * @since 2021/5/24
 */
public class LC_664 {
    /**
     * 第二类区间模型
     * dp[i][j] i-j之间的 最少打印次数
     * @param s
     * @return
     */
    public int strangePrinter(String s) {
        int n = s.length();
        int[][] f = new int[n][n];
        for (int i = 0; i < n; i++) {
            f[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len  <= n; i++) {
                int j = i + len - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    f[i][j] = f[i][j - 1];
                } else {
                    int minn = Integer.MAX_VALUE;
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, f[i][k] + f[k + 1][j]);
                    }
                    f[i][j] = minn;
                }
            }
        }
        return f[0][n - 1];
    }
}
