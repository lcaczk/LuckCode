package com.wkk.bitoperation;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class LC_231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) {
            return false;
        }
        while (n % 2 == 0) {
            n /= 2;
        }
        return n == 1;
    }

    public boolean isPowerOfTwoII(int n) {
        // 统计1的个数 n&(n-1)
        // 1   0001
        // 2   0010
        // 4   0100
        // 8.  1000
        // 只有1个1
        return (n & (n - 1)) == 0 || n == 1;
    }
}
