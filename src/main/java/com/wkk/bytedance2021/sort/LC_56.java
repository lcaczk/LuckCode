package com.wkk.bytedance2021.sort;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        int len = intervals.length;
        int[][] res = new int[len][2];
        // 共六种情况
        // 两个区间 a , b
        // a 整体在 b 左边
        // a 整体在 b 右边
        // a 和 b 相交
        // b 整体在 a 左边
        // b 整体在 a 右边
        // b 和 a 相交
        // 统一为三种情况 最后再统一为两种情况 相交｜不相交
        int idx = -1;
        for (int[] interval : intervals) {
            if (idx == -1 || res[idx][1] < interval[0]) {
                res[++idx] = interval;
            } else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}
