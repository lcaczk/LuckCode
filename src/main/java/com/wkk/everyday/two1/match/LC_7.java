package com.wkk.everyday.two1.match;

/**
 * @author weikunkun
 * @since 2021/5/3
 */
public class LC_7 {
    public static int reverse(int x) {
        boolean flag = false;
        long temp = x;
        if (x < 0) {
            flag = true;
            temp = -temp;
        }
        long ans = 0;
        int digit = 10;
        while (temp != 0) {
            long pop = temp % 10;
            if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && pop > 7))
                return 0;
//            if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && pop < -8))
//                return 0;
            ans = pop + ans * digit;
            temp /= 10;
        }
        if (flag) {
            return -(int) ans;
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        reverse(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
    }
}
