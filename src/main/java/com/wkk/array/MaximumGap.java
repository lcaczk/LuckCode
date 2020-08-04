package com.wkk.array;

import java.util.Arrays;

/**
 * @author kongwiki@163.com
 * @since 2020/8/3上午10:06
 */
public class MaximumGap {
    public int maximumGap(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = 0;
        for (int i = 1; i < nums.length; i++) {
            int temp = nums[i] - nums[i - 1];
            max = Math.max(temp, max);
        }
        return max;
    }
}
