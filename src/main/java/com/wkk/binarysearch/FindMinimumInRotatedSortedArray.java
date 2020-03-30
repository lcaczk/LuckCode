package com.wkk.binarysearch;

/**
 * @Time: 20-3-30下午5:25
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FindMinimumInRotatedSortedArray {
    public int findMin(int[] nums) {
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] >= nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;

            if(nums[indexMid] >= nums[index1]){
                index1 = indexMid;
            }else if(nums[indexMid] <= nums[index2]){
                index2 = indexMid;
            }

        }
        return nums[indexMid];

    }
}
