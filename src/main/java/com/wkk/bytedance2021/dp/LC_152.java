package com.wkk.bytedance2021.dp;

/**
 * 乘积最大子数组
 * @author weikunkun
 * @since 2021/4/13
 */
public class LC_152 {
    public int maxProduct(int[] nums) {
        int[] max = new int[nums.length];
        int[] min = new int[nums.length];
        int res = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max[i] = min[i] = nums[i];
            if (i > 0) {
                max[i] = Math.max(max[i], Math.max(max[i-1] * nums[i], min[i-1] * nums[i]));
                min[i] = Math.min(min[i], Math.min(max[i-1] * nums[i], min[i-1] * nums[i]));
                res = Math.max(res, max[i]);
            }
        }
        return res;
    }
}
