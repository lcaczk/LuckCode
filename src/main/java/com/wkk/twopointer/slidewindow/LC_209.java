package com.wkk.twopointer.slidewindow;

/**
 * 209. 长度最小的子数组
 * 滑动窗口
 * 因为求的是子数组，所有滑动窗口适用
 * 滑动窗口脑子里面构造图
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = 0;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (right < N) {
            sum += nums[right];
            while (left <= right && sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
