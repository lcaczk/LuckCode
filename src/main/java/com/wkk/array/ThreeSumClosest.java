package com.wkk.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

/**
 * @Time: 20-3-12下午3:58
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreeSumClosest {
    private static final Map<Integer, Integer> map = new HashMap<>();
    public static int threeSumClosest(int[] nums, int taget) {
        Arrays.sort(nums);
        int results = nums[1] + nums[0] + nums[nums.length - 1];
        for (int i = 0; i < nums.length - 2; i++) {
            int low = i+1, high = nums.length - 1;
            while (low < high) {
                int temp = nums[low] + nums[high] + nums[i];
                if (temp < taget) {
                    low++;
                } else {
                    high--;
                }
                if (Math.abs(temp-taget) < Math.abs(results-taget)){
                    results = temp;
                }
            }
        }
        return results;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2};
        int taget = 3;
        int i = threeSumClosest(nums, taget);
        System.out.println(i);

    }
}
