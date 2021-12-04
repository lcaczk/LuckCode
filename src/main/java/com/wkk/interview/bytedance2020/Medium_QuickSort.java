package com.wkk.interview.bytedance2020;

import com.common.utils.SortUtils;

import java.util.Arrays;

/**
 * @Time: 2020/7/20上午11:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_QuickSort {
    public void quickSort(int[] nums){
        quickSort(nums, 0 , nums.length-1);
    }
    private void quickSort(int[] nums, int low, int high){
        if(low < high){
            int partition = partition(nums, low, high);
            quickSort(nums, low, partition-1);
            quickSort(nums, partition+1, high);
        }
    }
    private int partition(int[] nums, int low, int high){
        int position = nums[low];
        while (low < high){
            while (low < high && nums[high] >= position){
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= position){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = position;
        return low;
    }

    public static void main(String[] args) {
        Medium_QuickSort quickSort = new Medium_QuickSort();
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = SortUtils.generateRandomArray(maxSize, maxValue);
            int[] arr2 = Arrays.copyOf(arr1, arr1.length);
            quickSort.quickSort(arr1);
            SortUtils.comparator(arr2);
            if (!SortUtils.isEqual(arr1, arr2)) {
                succeed = false;
                break;
            }
        }
        System.out.println(succeed ? "算法正确" : "艹 错了");
    }
}
