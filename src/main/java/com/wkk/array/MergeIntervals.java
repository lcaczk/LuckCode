package com.wkk.array;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Time: 2020/7/19下午9:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MergeIntervals {
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

    public static void main(String[] args) {
        int[][] a = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merge = merge(a);
        for (int[] ints : merge) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }

    }
}
