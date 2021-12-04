package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class AC_3787 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int rst = a % b;
            if (rst != 0) {
                System.out.println(b - rst);
            } else {
                System.out.println(0);
            }
        }
    }
}
