package com.wkk.binarysearch;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class LC_209 {
    public static int minSubArrayLen(int target, int[] nums) {
        int N = nums.length;
        int left = 0;
        int right = 0;
        int sum = 0;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }
        int ans = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            int next = preSum[i] + target;
            int pos = binarySearch(preSum, next);
            if (pos < 0) {
                continue;
            }
            if (pos <= N) {
                ans = Math.min(ans, pos - i);
            }
        }
        return ans;
    }

    private static int binarySearch(int[] array, int target) {
        int N = array.length;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return array[left] >= target ? left : -1;
    }

    public static void main(String[] args) {
        int target = 100;
        int[] array = {2, 3, 1, 2, 4, 3};
        minSubArrayLen(target, array);
    }
}
