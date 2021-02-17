package com.wkk.top100.array.medium;

/**
 * @author weikunkun
 * @since 2021/2/17
 */
public class LC_238 {
    public int[] productExceptSelf(int[] nums) {
        // 循环两次
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        first[0] = 1;
        second[nums.length - 1] = 1;
        for (int i = 1; i < nums.length; i++) {
            first[i] = nums[i - 1] * first[i - 1];
        }
        for (int i = nums.length - 2; i > 0; i--) {
            second[i] = second[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = first[i] * second[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        LC_238 lc_238 = new LC_238();
        lc_238.productExceptSelf(array);
    }
}
