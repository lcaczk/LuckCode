package com.wkk.simulation;

/**
 * @author weikunkun
 * @since 2021/4/21
 */
public class 快速幂 {
    public static long binpow(int a, int b) {
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 0) {
                res = res * a;
            }
            a = a * a;
            b >>>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        binpow(3,10);
    }
}
