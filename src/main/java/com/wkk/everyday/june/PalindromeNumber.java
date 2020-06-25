package com.wkk.everyday.june;

/**
 * @Time: 2020/6/10上午8:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (reverse < x) {
            reverse = x % 10 + reverse * 10;
            x /= 10;
        }
        return x == reverse || reverse / 10 == x;
    }
}
