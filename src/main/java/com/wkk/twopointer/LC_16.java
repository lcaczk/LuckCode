package com.wkk.twopointer;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/5/26
 */
public class LC_16 {
    public int threeSumClosest(int[] nums, int target) {
        int N = nums.length;
        Arrays.sort(nums);
        // 如何判断最近？
        // min(closest, curDistance)
        int closest = Integer.MAX_VALUE;
        int res = nums[0] + nums[nums.length - 1] + nums[1];
        for (int i = 0; i < N - 2; i++) {
            int low = i + 1;
            int height = N - 1;
            while (low < height) {
                int innerCur = nums[i] + nums[low] + nums[height];
                if (innerCur < target) {
                    low++;
                } else if (innerCur > target) {
                    height--;
                } else {
                    return target;
                }
                if (Math.abs(innerCur - target) < closest) {
                    closest = Math.abs(innerCur - target);
                    res = innerCur;
                }
            }
        }
        return res;
    }
}
