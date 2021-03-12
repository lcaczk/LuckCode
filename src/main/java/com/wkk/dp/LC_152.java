package com.wkk.dp;

/**
 * 152. 乘积最大子数组
 *
 * @author weikunkun
 * @since 2021/3/11
 */
public class LC_152 {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (i > 0) {
                max[i] = Math.max(max[i], Math.max(nums[i] * max[i - 1], nums[i] * min[i - 1]));
                min[i] = Math.min(min[i], Math.min(nums[i] * max[i - 1], nums[i] * min[i - 1]));
            }
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
