package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class 序列凑零 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T -- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; i ++) {
                a[i] = sc.nextInt();
            }

            for (int i = n - 1; i >= 0; i--) {
                // if (i % 2 == 1) {
                //     System.out.printf(-a[i] + " ");
                // } else {
                //     System.out.printf(a[i] + " ");
                // }
                System.out.print((int)Math.pow(-1, i) * a[i] + " ");
            }
            System.out.println();
        }
    }
}
