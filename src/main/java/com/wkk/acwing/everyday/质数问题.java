package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/4
 */
public class 质数问题 {
    //
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

    }
    private static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
