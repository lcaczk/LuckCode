package com.wkk.interview.bytedance2021.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 56 合并区间
 * @author weikunkun
 * @since 2021/3/16
 */
public class LC_56 {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int[][] res = new int[intervals.length][2];
        int idx = -1;
        for (int[] interval : intervals) {
            if(idx == -1 || interval[0] > res[idx][1]){
                res[++idx] = interval;
            }else {
                res[idx][1] = Math.max(interval[1], res[idx][1]);
            }
        }
        // idx最后标识的是最后一个重叠区间的位置, 因为是从0开始, 所以需要+1
        return Arrays.copyOf(res, idx+1);
    }
}
