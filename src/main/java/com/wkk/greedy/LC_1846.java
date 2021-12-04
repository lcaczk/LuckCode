package com.wkk.greedy;

import java.util.Arrays;

/**
 * 减小和重新排列数组后的最大元素
 * 贪心，先排序，然后按照题意，两个连续元素的位置之间差<=1
 * @author weikunkun
 * @since 2021/7/15
 */
public class LC_1846 {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        int max = Integer.MIN_VALUE;
        arr[0] = 1;
        int r = 1;
        while (r < n) {
            // <= 1无视
            // > 1 当前元素
            if ((arr[r] - arr[r - 1]) > 1) {
                arr[r] = arr[r - 1] + 1;
                max = Math.max(arr[r], max);
            } else {
                max = Math.max(arr[r], max);
            }
            r++;
        }
        return max == Integer.MIN_VALUE ? 1 : max;
    }
}
