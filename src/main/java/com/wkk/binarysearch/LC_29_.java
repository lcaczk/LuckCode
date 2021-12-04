package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/10/12
 */
public class LC_29_ {
    public int divide(int dividend, int divisor) {
        // 思路
        // 二分 + 快速幂
        long a = dividend;
        long b = divisor;
        boolean isNeg = a * b < 0;
        a = Math.abs(a);
        b = Math.abs(b);

        long l = 0;
        long r = a;
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(b, mid) > a) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        // 返回结果
        // 注意整型溢出
        if (isNeg) {
            l = -l;
        }
        int ans = l >= Integer.MAX_VALUE ? Integer.MAX_VALUE : (int) l;
        return ans;
    }

    private long check(long a, long b) {
        long sum = 0;
        while (b != 0) {
            if ((b & 1) == 1) {
                sum += a;
            }
            a += a;
            b >>= 1;
        }
        return sum;
    }
}
