package com.wkk.array;

/**
 * @Time: 20-3-12下午5:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NextPermutation {
    public void nextPermutation(int[] nums){
        for (int i = nums.length-1; i >= 0; i--) {
            int current = nums[i];
            for (int j = nums.length-2; j >= 0; j--) {
                if(nums[j] < current){
                    int temp = current;
                    current = nums[j];
                    nums[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};

    }
}
