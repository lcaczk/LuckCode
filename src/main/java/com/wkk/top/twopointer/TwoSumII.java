package com.wkk.top.twopointer;

/**
 * @Time: 2020/6/26上午10:05
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TwoSumII {
    public static int[] twoSum(int[] numbers, int target) {
        int low = 0;
        int height = numbers.length - 1;
        int[] res = new int[2];
        while (low < height) {
            int sum = numbers[low] + numbers[height];
            if(sum < target) {
                low++;
            } else if (sum > target) {
                height--;
            }else {
                res[0] = low;
                res[1] = height;
                return res;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {3, 24, 50, 79, 88, 150, 345};
        int[] ints = twoSum(nums, 200);


    }
}
