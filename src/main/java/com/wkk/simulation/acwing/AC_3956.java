package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/11
 */
public class AC_3956 {
    static int N = 100010;
    static int a[] = new int[N], s[] = new int[N], b[] = new int[N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }
        int tar = s[n] / 3;
        if (tar * 3 != s[n]) {
            System.out.println(0);
            return;
        }
        for (int i = n; i >= 1; i--) {
            if (s[n] - s[i - 1] == tar) {
                b[i]++;
            }
        }
        for (int i = n; i >= 1; i--)
            b[i] += b[i + 1];

        long res = 0;
        for (int i = 1; i <= n; i++)
            if (s[i] == tar) {
                res += b[i + 2];
            }
        System.out.println(res);

    }
}
