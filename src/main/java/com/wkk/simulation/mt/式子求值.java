package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class 式子求值 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int res = 0;
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = p[i - 1] ^ i;
            res = res ^ scan.nextInt();
        }
        for (int j = 2; j <= n; j++) {
            int pp = n / j;
            int qq = n % j;
            if (pp % 2 == 1) {
                res = res ^ p[j - 1] ^ p[qq];
            } else {
                res = res ^ p[qq];
            }
        }
        System.out.println(res);
    }
}
