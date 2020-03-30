package com.wkk.array;

/**
 * @Time: 20-3-30上午10:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[result]) {
                nums[result] = nums[i];
                result++;
            }

        }
        return nums == null ? 0 : result + 1;

    }
}
