package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/17
 */
public class AC_3807 {
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
        StringBuilder sb = new StringBuilder();
        int time = n / k;
        int rst = n % k;
        for (int i = 0; i < k - 1; i++) {
            for (int j = 0; j < time; j++) {
                sb.append((char)('a' + i));
            }
        }

        for (int i = 0; i < time + rst; i++) {
            sb.append((char)('a' + k - 1));
        }
        System.out.println(sb.toString());
    }
}
