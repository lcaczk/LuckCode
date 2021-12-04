package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/26
 */
public class AC_3817 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int na = sc.nextInt();
        int nb = sc.nextInt();
        int k = sc.nextInt();
        int m = sc.nextInt();
        long[] arra = new long[na];
        long[] arrb = new long[nb];
        for (int i = 0; i < na; i++) {
            arra[i] = sc.nextLong();
        }
        for (int i = 0; i < nb; i++) {
            arrb[i] = sc.nextLong();
        }
        cal(arra, na, k, arrb, nb, m);
    }

    private static void cal(long[] arra, int na, int k, long[] arrb, int nb, int m) {
        long first = arra[k - 1];
        long second = arrb[nb - m];
        if (first < second) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
