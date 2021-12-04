package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/9/23
 */
public class LC_26 {
    public static int removeDuplicates(int[] nums) {
        int n = nums.length;
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j == 0 || nums[i] != nums[j]) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }

    public static void main(String[] args) {
        int[] array = {0,0,1,1,1,2,2,3,3,4};
        removeDuplicates(array);
    }
}
