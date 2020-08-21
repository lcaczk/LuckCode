package com.wkk.easy;

/**
 * @Time: 20-3-24下午5:31
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int sum = (0 + nums.length-1)*nums.length/2;
        for (int num : nums) {
            sum -= num;
        }
        return sum;
    }
}
