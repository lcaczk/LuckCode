package com.wkk.bytedance2021.sort;

import java.util.Arrays;

/**
 * 164 最大间距
 * @author weikunkun
 * @since 2021/4/1
 */
public class LC_164 {
    public int maximumGap(int[] nums) {
        if (null == nums || nums.length < 2) {
            return 0;
        }
        Arrays.sort(nums);
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            max = Math.max((nums[i] - nums[i-1]), max);
        }
        return max;
    }
}
