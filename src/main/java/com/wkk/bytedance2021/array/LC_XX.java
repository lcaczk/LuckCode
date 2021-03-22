package com.wkk.bytedance2021.array;

/**
 * @author weikunkun
 * @since 2021/3/22
 */
public class LC_XX {
    public int[] sortArrayByParity(int[] A) {
        // 思路 双指针
        if (null == A || A.length == 0) {
            return A;
        }
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (left < right && A[right] / 2 == 1) {
                right--;
            }
            while (left < right && A[left] / 2 == 0) {
                left++;
            }
            if (left < right) {
                swap(A, left, right);
            }
        }
        return A;
    }

    private void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    public int nthUglyNumber(int n, int a, int b, int c) {
        // 思路
        // 先设计检测是否为丑数的函数，然后从1循环，寻找第n个丑数
        int number = 0;
        int idx = 0;
        while (idx < n) {
            number++;
            if (uglyNumber(number, a, b, c)) {
                idx++;
            }
        }
        return number+1;
    }

    private boolean uglyNumber(int number, int a, int b, int c) {
        while ((number % a == 0)) {
            number /= a;
        }
        while ((number % b == 0)) {
            number /= b;
        }
        while ((number % c == 0)) {
            number /= c;
        }
        return number == 1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        LC_XX lc_xx = new LC_XX();
        lc_xx.sortArrayByParity(arr);
    }
}
