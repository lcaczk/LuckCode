package com.wkk.twopointer;

/**
 * @author weikunkun
 * @since 2021/7/17
 */
public class Offer_21 {
    public static int[] exchange(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            while (nums[i] % 2 == 1) {
                i++;
            }
            while (nums[j] % 2 == 0) {
                j--;
            }
            swap(nums, i, j);
//            i++;
//            j--;
        }
        return nums;
    }

    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 6, 8};
        exchange(nums);
    }
}
