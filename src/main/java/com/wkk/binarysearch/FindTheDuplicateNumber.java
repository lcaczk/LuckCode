package com.wkk.binarysearch;

/**
 * @Time: 2020/5/24上午9:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int i = 1;
        int j = nums.length-1;
        while (i < j){
            int count = 0;
            int mid = (i + j) >>1;
            // 统计小于中间位置的数字的个数
            for (int num : nums) {
                if(num <= mid){
                    count++;
                }
            }
            if(count > mid){
                j = mid;
            }else {
                i = mid + 1;
            }
        }
        return i;
    }
}
