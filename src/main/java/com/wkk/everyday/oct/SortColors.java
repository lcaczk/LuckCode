package com.wkk.everyday.oct;

import java.util.Arrays;

/**
 * 题目: 75.颜色分类
 * 题目链接: https://leetcode-cn.com/problems/sort-colors/
 * <p>
 * 描述:
 * 给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，
 * 使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
 * <p>
 * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色
 * 思路: 说白了就是基础排序问题
 * @author kongwiki@163.com
 * @since 2020/10/7
 */
public class SortColors {
    public void sortColors(int[] nums){
        Arrays.sort(nums);
    }

    //插入排序
    private void insertSort(int[] nums){
        for(int i = 1; i <= nums.length-1; i++){
            int cur = nums[i];
            int j = i - 1;
            while(j >= 0 && nums[j] >= cur){
                nums[j + 1] = nums[j];
                j = j - 1;
            }
            nums[j+1] = cur;
        }
    }

    // 快排
    public void sortColorsII(int[] nums) {
        int len = nums.length-1;
        quickSorted(nums, 0, len);
    }
    private void quickSorted(int[] nums, int low, int high){
        if(low < high){
            int position = position(nums, low, high);
            quickSorted(nums, low, position-1);
            quickSorted(nums, position+1, high);
        }
    }
    private int position(int[] nums, int low, int high){
        int povity = nums[low];
        while(low < high){
            while(low < high && nums[high] >= povity){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= povity){
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = povity;
        return low;
    }
}
