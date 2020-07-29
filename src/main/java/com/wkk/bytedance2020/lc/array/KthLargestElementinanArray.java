package com.wkk.bytedance2020.lc.array;

/**
 * @Time: 2020/7/29上午9:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KthLargestElementinanArray {
    // 快排
    public int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int n = nums.length;
        int pos = position(nums, 0, n-1);
        k = n-k;
        int low = 0;
        while(pos != k){
            if(pos < k){
                // 去右边找
                pos = position(nums, pos+1, n-1);
            }else{
                // 去左边找
                pos = position(nums, low, pos-1);
            }
        }
        return nums[pos];

    }

    // 寻找位置
    private int position(int[] nums, int low, int high){
        int pos = nums[low];
        while(low < high){
            while(low < high && nums[high] >= pos){
                high--;
            }
            nums[low] = nums[high];
            while(low < high && nums[low] <= pos){
                low++;
            }
            nums[high] = nums[low];

        }
        nums[low] = pos;
        return low;
    }
}
