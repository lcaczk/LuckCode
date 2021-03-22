package com.wkk.bytedance2021.array;

/**
 * @author weikunkun
 * @since 2021/3/22
 */
public class LC_1201 {
    public int nthUglyNumber(int n, int a, int b, int c) {
        long l = 1, r = Integer.MAX_VALUE;
        long ab = lcm(a, b);
        long ac = lcm(a, c);
        long bc = lcm(b, c);
        long abc = lcm(a, bc);

        while (l < r) {
            long mid = l + r >> 1;
            long count = mid / a + mid / b + mid / c - mid / ab - mid / ac - mid / bc + mid / abc;
            if (count >= n) r = mid;
            else l = mid + 1;
        }
        return (int) l;
    }

    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    private long gcd(long x, long y) {
        if (x == 0) return y;
        return gcd(y % x, x);
    }

}
