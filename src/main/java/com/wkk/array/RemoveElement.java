package com.wkk.array;

/**
 * @Time: 20-3-30上午10:26
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != val){
                nums[result] = nums[i];
                result++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,2,3};
        int val = 3;
        int i = removeElement(nums, val);
        System.out.println(i);
    }
}
