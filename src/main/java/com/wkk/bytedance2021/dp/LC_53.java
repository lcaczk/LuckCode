package com.wkk.bytedance2021.dp;

import java.util.Objects;

/**
 * 53 最大子序和
 * @author weikunkun
 * @since 2021/3/14
 */
public class LC_53 {
    public int maxSubArray(int[] nums) {
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            if (max < sum) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }
}
