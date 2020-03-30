package com.wkk.array;

/**
 * @Time: 20-3-30上午11:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FirstMissingPositive {
    //可以使用位图

    /**
     * [0,1,2,3,4]
     * [1,2,3,4,5]
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= 1 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            } else {
                i++;
            }
        }
        i = 0;
        while (i < nums.length && nums[i] == i + 1) {
            i++;
        }
        return i + 1;

    }

    public int firstMissingPositiveII(int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 1;
        }
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] < nums.length && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != i+1){
                return i+1;
            }
        }
        return nums.length+1;

    }


    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
