package com.wkk.interview.bytedance2020;

import java.util.Arrays;

/**
 * @Time: 2020/7/25上午10:03
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_MergeIntervals {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (x, y)->(x[0]-y[0]));
        int m = intervals.length;
        int[][] res = new int[m][2];
        int idx = -1;
        for(int[] interval: intervals){
            // 不相交(interval[0] > res[idx][1]) 直接放入
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }
            // 相交 进行判断 原的第2个位置和新的第二个位置
            // interval[0] <= res[idx][1]
            else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}
