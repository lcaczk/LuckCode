package com.wkk.interview.bytedance2021.math;

/**
 * @author weikunkun
 * @since 2021/4/17
 */
public class XXX {
    public static boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int sum = 0;
        while (sum < x) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum / 10 == x || sum == x;
    }

    public static boolean isPalindromeII(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        if (x == 0) {
            return true;
        }
        int temp = x;
        int sum = 0;
        while (x > 0) {
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return sum == temp;
    }

    public static void main(String[] args) {
        isPalindromeII(11);
    }
}
