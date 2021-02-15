package com.wkk.top100.array.easy;

/**
 * 70 爬楼梯
 * @author weikunkun
 * @since 2021/2/15
 */
public class LC_70 {
    public int climbStairs(int n) {
        int[] array = new int[n];
        array[0] = 1;
        array[1] = 2;
        for (int i = 2; i < n; i++) {
            array[i] = array[i-1] + array[i-2];
        }
        return array[n-1];
    }
}
