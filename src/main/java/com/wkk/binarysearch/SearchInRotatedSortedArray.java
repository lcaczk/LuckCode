package com.wkk.binarysearch;

/**
 * @Time: 20-3-30下午3:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SearchInRotatedSortedArray {
    public static int search(int[] nums, int target) {
        int split = getSplit(nums);
        int index = 0;
        if(nums[split] == target){
            index = split;
        }
        if (nums[nums.length - 1] < target) {
            index = bSearch(nums, 0, split - 1, target);

        } else {
            index = bSearch(nums, split, nums.length - 1, target);
        }
        return index;
    }

    public static int bSearch(int[] nums, int i, int j, int target) {
        int low = i;
        int hight = j;
        while (low <= hight) {
            if (low == hight && nums[low] != target) {
                return -1;
            }
            int mid = (low + hight) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                hight = mid;
            } else {
                low = mid+1;
            }
        }
        return hight;
    }

    public static int getSplit(int[] nums) {
        int index1 = 0, index2 = nums.length - 1, indexMid = index1;
        while (nums[index1] > nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            indexMid = (index1 + index2) / 2;
            if (nums[index1] <= nums[indexMid]) {
                index1 = indexMid;
            } else if (nums[index2] >= nums[indexMid]) {
                index2 = indexMid;
            }

        }
        return indexMid;
    }

    public static void main(String[] args) {
        int[] a = {4, 5, 6, 9, 0, 1, 2, 3};
        int search = search(a, 8);
        System.out.println(search);
    }


}
