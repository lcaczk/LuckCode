package com.wkk.binarysearch;

/**
 * @Time: 20-3-30下午5:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] nums) {
        int index1 = 0;
        int indexMid = index1;
        int index2 = nums.length - 1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index2 + index1) / 2;
            if (nums[indexMid] == nums[index1] && nums[index1] == nums[index2]) {
                int i = inOrder(nums, index1, index2);
                return i;
            }

            if (nums[index1] <= nums[indexMid]) {
                index1 = indexMid;
            } else if (nums[index2] >= nums[indexMid]) {
                index2 = indexMid;
            }
        }
        return nums[indexMid];
    }

    private int inOrder(int[] nums, int index1, int index2) {
        int result = nums[index1];
        for (int i = index1; i < index2; i++) {
            if (nums[i] < result) {
                result = nums[i];
            }

        }
        return result;
    }
}
