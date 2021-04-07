package com.wkk.math;

/**
 * 9. 回文数
 * @author weikunkun
 * @since 2021/4/5
 */
public class LC_9 {
    public boolean isPalindrome(int x) {
        // 对半检测
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int temp = 0;
        while (temp < x) {
            temp = temp * 10 + x%10;
            x  /= 10;
        }
        return temp == x || x/10 == temp;
    }

    public static void main(String[] args) {
        LC_9 lc_9 = new LC_9();
        lc_9.isPalindrome(11);
    }
}
