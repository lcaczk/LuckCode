package com.wkk.array;

/**
 * @Time: 20-3-12下午5:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NextPermutation {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length -1;
            while (nums[i] <= nums[j]){
                j--;
            }
            swap(nums, i, j);

        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public void reverse(int[] A, int i, int j) {
        while (i < j) {
            swap(A, i++, j--);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 5};
        for (int num : nums) {
            System.out.print(num + " ");
        }

    }
}
