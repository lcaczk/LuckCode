package com.wkk.everyday.july;

/**
 * @Time: 2020/7/1下午4:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MaximumLengthOfRepeatedSubarray {
    public static int findLength(int[] A, int[] B) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int temp = i;
            for (int j = 0; j < B.length; j++) {
                while (temp < A.length && j < B.length && A[temp] == B[j]) {
                    temp++;
                    j++;
                }
                max = Math.max(max, temp - i);
                temp = i;
            }

        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 0, 1};
        int[] b = {1, 0, 0, 0, 0};
         int length = findLength(a, b);
        System.out.println(length);
    }
}
