package com.wkk.binarysearch;

/**
 * @Time: 20-3-30下午4:47
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SearchInRotatedSortedArrayII {
    public static boolean search(int[] nums, int target) {
        int mid = getMid(nums);
        boolean flag = false;
        if (nums[mid] == target) {
            return true;
        }
        if (nums[mid] < target) {
            flag = bSearch(nums, mid + 1, nums.length - 1, target);
        } else {
            flag = bSearch(nums, 0, mid, target);
        }
        return flag;
    }

    public static boolean bSearch(int[] nums, int i, int j, int target) {
        while (i <= j) {
            int mid = (i + j) / 2;
            if (i == j && nums[i] == target) {
                return true;
            }
            if (nums[i] < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return false;
    }

    public static int getMid(int[] nums) {
        int index1 = 0;
        int index2 = nums.length - 1;
        int indexMid = index1;
        while (nums[index1] <= nums[index2]) {
            if (index2 - index1 == 1) {
                indexMid = index2;
                break;
            }
            if(nums[index1] == nums[index2] && nums[index1] == nums[indexMid]){
                getInOrder(nums, index1, index2);
            }
            indexMid = (index1 + index2) / 2;
            if (nums[indexMid] >= nums[index1]) {
                index1 = indexMid;
            } else if (nums[indexMid] <= nums[index2]) {
                index2 = indexMid;
            }

        }
        return indexMid;
    }

    public static int getInOrder(int[] nums, int start , int end){
        //TODO
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int target = 0;
        boolean search = search(nums, target);
        System.out.println(search);
    }
}
