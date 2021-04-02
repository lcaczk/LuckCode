package com.wkk.bytedance2021.dp;

/**
 * 312 打气球
 * @author weikunkun
 * @since 2021/4/1
 */
public class LC_312 {
    /**
     * 暴力
     * 超时
     */
    public int maxCoins(int[] nums) {
        if (null == nums || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int N = nums.length;
        int[] help = new int[N + 2];
        help[0] = 1;
        help[N + 1] = 1;
        for (int i = 0; i < N; i++) {
            help[i + 1] = nums[i];
        }
        return process(help, 1, N);
    }

    private int process(int[] nums, int left, int right) {
        if (left == right) {
            return nums[left-1] * nums[left] * nums[right+1];
        }
        // 最后打爆arr[L]的方案和最后打爆arr[R]的方案 选最大的。
        int max = Math.max(
                nums[left - 1] * nums[left] * nums[right + 1] + process(nums, left + 1, right),
                nums[left - 1] * nums[right] * nums[right + 1] + process(nums, left, right -1)
        );
        // 尝试中间位置的气球最后被打爆的每一个方案
        for (int i = left +1; i < right; i++) {
            max = Math.max(
                    nums[left-1] * nums[i] * nums[right + 1] + process(nums, left, i - 1) + process(nums, i + 1, right),
                    max
            );
        }
        return max;
    }
}
