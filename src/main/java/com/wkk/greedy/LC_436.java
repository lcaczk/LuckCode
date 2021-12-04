package com.wkk.greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_436 {
    public static int[] findRightInterval(int[][] intervals) {
        int n = intervals.length;
        Map<int[], Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(intervals[i], i);
        }
        Arrays.sort(intervals, (x , y) -> (x[0] - y[0]));
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int[] innerInteval = intervals[i];
            int right = innerInteval[1];
            int j = i + 1;
            int minIdx = -1;
            int min = Integer.MAX_VALUE;
            while (j < n) {
                if (intervals[j][0] >= right) {
                    minIdx = map.get(intervals[j]);
                    break;
                }
                j++;
            }
            ans[map.get(intervals[i])] = minIdx;
        }
        return ans;
    }

    public static void main(String[] args) {
//        int[][] matrix = {{3, 4}, {2, 3}, {1, 2}};
        int[][] matrix = {{1, 1}, {3, 4}};
        findRightInterval(matrix);
    }
}
