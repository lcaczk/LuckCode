package com.wkk.greedy;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int idx = -1;
        for (int[] tmp : intervals) {
            int inL = tmp[0];
            int inR = tmp[1];
            // 新增区间
            if (idx == -1 || inL > ans[idx][1]) {
                ans[++idx] = tmp;
            } else {
                ans[idx][1] = Math.max(ans[idx][1], inR);
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }

    /**
     * 维护一个右端点
     * @param intervals
     * @return
     */
    public int[][] mergeII(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int idx = -1;
        int right = Integer.MIN_VALUE;
        for (int[] interval : intervals) {
            int innerLeft = interval[0];
            int innerRight = interval[1];
            if (innerLeft > right) {
                ans[++idx] = interval;
                right = ans[idx][1];
            } else {
                ans[idx][1] = Math.max(innerRight, ans[idx][1]);
                right = ans[idx][1];
            }
        }
        return Arrays.copyOf(ans, idx + 1);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        merge(matrix);
    }
}
