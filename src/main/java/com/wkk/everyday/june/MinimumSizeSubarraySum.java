package com.wkk.everyday.june;

/**
 * @Time: 2020/6/28上午8:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MinimumSizeSubarraySum {
    // 三种方法
    // 第一种 暴力枚举
    // 第二种 前缀和 + 二分查找
    // 第三种 双指针
    public static int minSubArrayLen(int s, int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = 0;
            for (int j = i; j < nums.length; j++) {
                temp += nums[j];
                if (temp >= s) {
                    min = Math.min(j - i + 1, min);
                    break;
                }
            }
        }
        return min;
    }

    public int minSubArrayLenII(int s, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;
        while (end < nums.length) {
            sum += nums[end];
            while (sum >= s) {
                res = Math.min(end - start + 1, res);
                sum -= nums[start++];

            }
            end++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        int i = minSubArrayLen(s, nums);
        System.out.println(i);
    }
}
