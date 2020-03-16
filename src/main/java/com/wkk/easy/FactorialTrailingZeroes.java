package com.wkk.easy;

/**
 * @Time: 20-3-16下午5:55
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FactorialTrailingZeroes {
    public static int trailingZeroes(int n) {
        int count = 0;

        while(n > 0) {
            n /= 5;
            count += n;
        }

        return count;
    }

    public static void main(String[] args) {
        int i = trailingZeroes(13);
        System.out.println(i);
    }
}
