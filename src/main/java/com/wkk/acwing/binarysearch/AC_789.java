package com.wkk.acwing.binarysearch;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/19
 */
public class AC_789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int count = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        // 两次二分，一次找一个边界
        while (count-- > 0) {
            int target = sc.nextInt();
            int left = 0;
            int right = len - 1;
            // 先找左边
            while (left < right) {
                int mid = (left + right) / 2;
                if (array[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            int leftIdx = array[left] == target ? left : -1;
            left = 0;
            right = len -1;
            // 再找右边
            while (left < right) {
                int mid = (left + right + 1) / 2 ;
                if (array[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }
            int rightIdx = array[left] == target ? left : -1;
            System.out.println(leftIdx + " " + rightIdx);
        }
    }
}
