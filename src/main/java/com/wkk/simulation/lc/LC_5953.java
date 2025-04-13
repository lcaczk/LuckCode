package com.wkk.simulation.lc;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/12/12
 */
public class LC_5953 {
    public static long subArrayRanges(int[] nums) {
        int n = nums.length;
        long res = 0;
        for (int i = 0; i < n; i++) { // 起始位置
            for (int j = 1; i + j <= n; j++) { // 步长
                int[] tmp = new int[j];
                System.arraycopy(nums, i, tmp, 0, j);
                int max = Arrays.stream(tmp).max().getAsInt();
                int min = Arrays.stream(tmp).min().getAsInt();
                res += max - min;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        System.out.println(subArrayRanges(arr));
    }
}
