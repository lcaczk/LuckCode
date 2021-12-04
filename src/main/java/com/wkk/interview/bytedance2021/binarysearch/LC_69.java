package com.wkk.interview.bytedance2021.binarysearch;

/**
 * 69 x的平方根
 *
 * @author weikunkun
 * @since 2021/3/17
 */
public class LC_69 {
    /**
     * 超出时间限制
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        // 思路
        // 暴力求解
        int res = 0;
        for (int i = 1; i * i <= x; i++) {
            if (i * i == x || isBetween(i, x)) {
                return i;
            }
        }
        return res;
    }

    private boolean isBetween(int sqrt, int target) {
        int next = sqrt + 1;
        if (next * next > target && sqrt * sqrt <= target) {
            return true;
        }
        return false;
    }


    /**
     * 二分查找
     * 注意边界情况
     * 以及整形溢出
     *
     * @param x
     * @return
     */
    public int mySqrtII(int x) {
        if (x == 1) {
            return 1;
        }
        // 二分查找
        int half = x / 2;
        int left = 0;
        int right = half;
        while (left < right) {
            int mid = (left + right + 1) / 2;
            if ((long) mid * mid > (long) x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
    }
}
