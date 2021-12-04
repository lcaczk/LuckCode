package com.wkk.interview.bytedance2020.lc.array;

/**
 * @Time: 2020/7/28下午9:29
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class BinarySearch {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int mid = minIndex(nums);
        int low1 = 0;
        int low2 = mid;
        int high1 = mid-1;
        int high2 = nums.length-1;
        if(target > nums[high2]){
            return binarySearch(nums, low1, high1, target);
        }else if(target < nums[high2]){
            return binarySearch(nums, low2, high2, target);
        }else {
            return high2;
        }


    }
    // 先查找最小元素的位置
    private int minIndex(int[] nums){
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low = 0;
        int high = nums.length-1;
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            }else if(nums[mid] < nums[high]){
                high = mid;
            }else {
                high--;
            }
        }
        return low;
    }

    // 二分查找 查找元素
    private int binarySearch(int[] nums, int low, int high, int target){
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] < target){
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return nums[low] == target ? low : -1;
    }

    public static void main(String[] args) {
        BinarySearch search = new BinarySearch();
        int[] a = {1,3,5};
        System.out.println(search.search(a, 1));
    }
}
