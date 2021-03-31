package com.wkk.top100.bitoperator.easy;

/**
 * @author weikunkun
 * @since 2021/3/29
 */
public class LC_190 {
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}

