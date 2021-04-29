package com.wkk.everyday.two1.april;

/**
 * 数学题
 *
 * @author weikunkun
 * @since 2021/4/28
 */
public class LC_633 {
    public boolean judgeSquareSum(int c) {
        int max = (int) Math.sqrt(c);
        int a = 0;
        int b = max;
        while (a <= b) {
            int cur = a * a + b * b;
            if (cur < c) {
                a++;
            } else if (cur > c) {
                b--;
            } else {
                return true;
            }
        }
        return false;
    }
}
