package com.wkk.array;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/8/4
 */
public class LC_611 {
    public static int triangleNumberI(int[] nums) {
        // 思路
        // a + b > c
        Arrays.sort(nums);
        int count = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = i + 1; j < n; j++) {
                if (nums[j] == 0) {
                    continue;
                }
                int cur = nums[i] + nums[j];
                int k = j + 1;
                while (k < n && nums[k] < cur) {
                    if (nums[k] == 0) {
                        continue;
                    }
                    count++;
                    k++;
                }
            }
        }
        return count;
    }

    public static int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length - 1;
        int sum = 0;
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                int t = nums[i] + nums[j];
                int n = find(nums, j, length, t);
                sum += (n - j);
            }
        }
        return sum;
    }

    private static int find(int[] arr, int st, int end, int t) {
        while (st < end) {
            int m = st + ((end - st + 1) >> 1);
            if (arr[m] < t) {
                st = m;
            } else {
                end = m - 1;
            }
        }
        return st;
    }


    public static void main(String[] args) {
        int[] nums = {2, 2, 3, 4};
        System.out.println(triangleNumber(nums));
    }
}
