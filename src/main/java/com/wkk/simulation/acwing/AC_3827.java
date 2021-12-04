package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/4
 */
public class AC_3827 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            cal(n, k);
        }
    }

    private static void cal(int n, int k) {
        if (k == 0) {
            System.out.println(n);
            return;
        }
        int tmp = n;
        int count = 0;
        while (tmp % 10 == 0) {
            count++;
            tmp /= 10;
        }
        if (count > k) {
            System.out.println(n);
            return;
        }
        int count2 = 0;
        int count5 = 0;
        int base = n;
        while (n % 2 == 0) {
            n /=2;
            count2++;
        }
        while (n % 5 == 0) {
            n /= 5;
            count5++;
        }
        // count < k
        count2 -= count;
        count5 -= count;
        k -= count;
        if (count2 != 0) {
            int need5 = 0;
            int need0 = 0;
            if (k >= count2) {
                need5 = count2;
                need0 = k - count2;
            } else {
                need5 = k > 0 ? k : 1;
            }
            long res = (long)(Math.pow(10, need0) * Math.pow(5, need5) * base);
            System.out.println(res);
        } else {
            int need2 = 0;
            int need0 = 0;
            if (k > count5) {
                need2 = count5;
                need0 = k - count5;
            } else {
                need2 = k > 0 ? k : 1;
            }
            long res = (long)(Math.pow(10, need0) * Math.pow(2, need2) * base);
            System.out.println(res);
        }
    }
}
