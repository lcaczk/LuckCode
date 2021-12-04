package com.wkk.greedy;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_435 {
    public static int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, (x, y) -> (x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]));
        printArr(intervals);
        int ans = 1;
        int n = intervals.length;
        int right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (intervals[i][0] >= right) {
                ans++;
                right = intervals[i][1];
            }
        }
        return n - ans;
    }

    private static void printArr(int[][] m) {
        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[0].length; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 100}, {11, 22}, {1, 11}, {2, 12}};
        eraseOverlapIntervals(matrix);
    }
}
