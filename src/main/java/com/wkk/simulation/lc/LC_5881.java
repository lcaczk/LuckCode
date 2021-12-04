package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/9/26
 */
public class LC_5881 {
    public static int maximumDifference(int[] nums) {
        int min = Integer.MAX_VALUE;
        int profit = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];

            }
            if (nums[i] - min > profit) {
                profit = nums[i] - min;
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        int[] array = {7, 1, 5, 4};
        System.out.println(maximumDifference(array));
    }
}
