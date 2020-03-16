package com.wkk.easy;

/**
 * @Time: 20-3-16下午7:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        k %= nums.length;
        int n = nums.length;
        reverse(nums, 0, n-k);
        reverse(nums,n-k, n );
        reverse(nums, 0, n);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end-1];
            nums[end-1] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        rotate(a, 3);
        for (int i : a) {
            System.out.print(i + " ");
        }
        System.out.println();

    }
}
