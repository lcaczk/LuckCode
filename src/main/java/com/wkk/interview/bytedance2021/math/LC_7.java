package com.wkk.interview.bytedance2021.math;

/**
 * @author weikunkun
 * @since 2021/4/9
 */
public class LC_7 {
    public int reverse(int x) {
        boolean flag = false;
        if (x < 0) {
            flag = true;
            x = -x;
        }
        int ans = 0;
        int digit = 10;
        while (x != 0) {
            int pop = x % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
                return 0;
            ans = pop + ans * digit;
            x /= 10;
        }
        if (flag) {
            return -ans;
        } else {
            return ans;
        }
    }

    public static void main(String[] args) {
        int a = 123;
        int b = 1534236469;
        System.out.println(b);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}
