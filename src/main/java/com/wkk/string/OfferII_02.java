package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/8/8
 */
public class OfferII_02 {
    public static int divide(int a, int b) {
        long x = a;
        long y = b;
        return (int)(x / y);
    }

    public static void main(String[] args) {
        int a = Integer.MIN_VALUE;
        int b = -1;
        System.out.println(divide(a, b));
    }
}
