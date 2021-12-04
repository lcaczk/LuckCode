package com.wkk.interview.bytedance2021.math;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 快速幂
 * @author weikunkun
 * @since 2021/4/30
 */
public class LC_50 {
    public static double myPow(double x, int n) {
        // 快速幂
        if(x == 0.0f) {
            return 0.0d;
        }
        double res = 1;
        boolean flag = n < 0;
        long b = n;
        if (b < 0) {
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        if (flag) {
            return 1 / res;
        }
        return res;
    }

    public static double myPowII(double x, int n) {
        // 快速幂
        if(x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if(b < 0) {
            x = 1 / x;
            b = -b;
        }
        while(b > 0) {
            if((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        myPowII(2.000, Integer.MIN_VALUE);
        Queue<Integer> queue = new ArrayDeque<>();
    }
}
