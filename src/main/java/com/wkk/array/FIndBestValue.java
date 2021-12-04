package com.wkk.array;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/6/27
 */
public class FIndBestValue {
    public int findBestValue(int[] arr, int target) {
        // 思路
        // 求平均数
        Arrays.sort(arr);
        int n = arr.length;
        int ans = arr[0];
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int cur = arr[i];
            int sum = genSum(arr, 0, i);
            for (int j = i + 1; j < n; j++) {
                sum += cur;
            }
            if (diff > Math.abs(sum - target)) {
                ans = sum;
                diff = Math.abs(sum - target);
            }
        }
        return ans;
    }

    private int genSum(int[] arr, int i, int j) {
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }

    public static void main(String[] args) {
        FIndBestValue value = new FIndBestValue();
        int[] arr = {4, 9, 3};
        value.findBestValue(arr, 10);
    }
}
