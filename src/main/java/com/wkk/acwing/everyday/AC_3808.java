package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/18
 */
public class AC_3808 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int sqrt = (int) Math.sqrt(n);
            int rst = n - sqrt * sqrt;
            int res = 2 * sqrt + (rst > sqrt ? 2 : 1);
            if (rst == 0) {
                res--;
            }
            System.out.println(res);
        }
    }
}
