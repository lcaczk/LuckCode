package com.wkk.easy;

/**
 * @Time: 20-3-16下午1:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Sqrt_69 {
    public static int mySqrt(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }

    public static void main(String[] args) {
        int a = 1;
        int i = mySqrt(a);
        System.out.println(i);
    }
}
