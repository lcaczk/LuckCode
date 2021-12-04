package com.wkk.simulation.lc;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/6/27
 */
public class LC_5797 {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if (n < 2) {
            return  0;
        }
        int max = nums[n - 1] * nums[n - 2];
        int min = nums[0] * nums[1];
        return max -min;
    }
}
