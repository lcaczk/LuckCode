package com.wkk.bitoperation;

/**
 * @author weikunkun
 * @since 2021/5/31
 */
public class LC_342 {
    public boolean isPowerOfFour(int n) {
        if (n <= 0) {
            return false;
        }
        // 求10101010。。。。1
        return ((n & (n - 1)) == 0) && ((n & 0xaaaaaaaa) == 0);
    }
}
