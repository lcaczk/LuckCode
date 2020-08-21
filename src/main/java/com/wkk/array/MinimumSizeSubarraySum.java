package com.wkk.array;

/**
 * @Time: 20-3-7上午10:07
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MinimumSizeSubarraySum {
    /**
     * 双指针法
     *
     * @param s
     * @param nums
     * @return
     */
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int p1 = 0, p2 = 0;
        int res = nums.length+1;
        int sum = 0;
        while (p2 < nums.length) {
            while (sum < s ) {
                sum += nums[p2++];
            }
            while (sum >= s) {
                res = Math.min(res, p2-p1);
                sum -= nums[p1++];
            }
        }
        return res==nums.length+1?0:res;
    }

    public static void main(String[] args) {
        int s = 7;
        int[] nums = {2,3,1,2,4,3};
        MinimumSizeSubarraySum sum = new MinimumSizeSubarraySum();
        int i = sum.minSubArrayLen(s, nums);
        System.out.println(i);
    }
}
