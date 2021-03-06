package com.wkk.top100.array.easy;

/**
 * 最大子序和
 * @author kongwiki@163.com
 * @since 2021/2/6
 */
public class LC_53 {
    public int maxSubArray(int[] nums) {
        // TODO 判空
        int max = nums[0];
        int sum = 0;
        for(int num : nums) {
            sum += num;
            if (sum >= max) {
                max = sum;
            }
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int maxSubArrayII(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static void main(String[] args) {
        int a = 2;
        System.out.println(a/10);
    }

}
