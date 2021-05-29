package com.wkk.twopointer;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/5/27
 */
public class LC_360 {
    public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        int N = nums.length;
        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            ans[i] = cal(a, b ,c, nums[i]);
        }
        Arrays.sort(ans);
        return ans;
    }

    private int cal(int a, int b, int c, int x) {
        return a * x * x + b * x + c;
    }
}
