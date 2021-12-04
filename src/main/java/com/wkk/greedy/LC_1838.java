package com.wkk.greedy;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/19
 */
public class LC_1838 {
    public int maxFrequency(int[] nums, int k) {
        // 贪心
        // 使得频率最多的元素出现的尽可能多
        Arrays.sort(nums);
        int n = nums.length;
        long sum = 0;
        int j = 0;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            while (sum + k < nums[i] * (i - j + 1)) {
                sum -= nums[j];
                j++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}
