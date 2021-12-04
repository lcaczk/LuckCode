package com.wkk.easy;

/**
 * @author weikunkun
 * @since 2021/11/4
 */
public class LC_367 {
    public static boolean isPerfectSquare(int num) {
        // 思路
        // for 循环
        for (int i = 1; i <= num / i; i++) {
            if (i * i == num) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
    }
}
