package com.wkk.array;

/**
 * @Time: 20-4-4下午9:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int maxSum = nums[0];
        for (int num : nums) {
            sum += num;
            if(sum > maxSum){
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {-3,-2,0,-1};
        int i = maxSubArray(a);
        System.out.println(i);
    }
}
