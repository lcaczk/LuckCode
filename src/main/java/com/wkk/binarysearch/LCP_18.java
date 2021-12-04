package com.wkk.binarysearch;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/9/26
 */
public class LCP_18 {
    private int mod = (int) 1e9 + 7;

    public int breakfastNumber(int[] staple, int[] drinks, int x) {
        // staple 主食
        // drinks 饮料
        Arrays.sort(staple);
        Arrays.sort(drinks);
        int n = staple.length;
        int m = drinks.length;
        // 二分
        int sum = 0;
        for (int num : staple) {
            int rst = x - num;
            int idx = find(drinks, rst, m - 1);
            System.out.println(idx);
            if (idx == -1) {
                continue;
            }
            sum += idx + 1;
        }
        return sum;
    }

    private int find(int[] array, int target, int n) {
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (array[mid] > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return array[i] <= target ? i : -1;
    }

    public static void main(String[] args) {
//        LCP_18 lcp_18 = new LCP_18();
//        int[] first = {2, 1, 1};
//        int[] second = {8, 9, 5, 1};
//        System.out.println(lcp_18.breakfastNumber(first, second, 15));
        long len = Long.MAX_VALUE;
        long[] arr = new long[Integer.MAX_VALUE];
    }
}
