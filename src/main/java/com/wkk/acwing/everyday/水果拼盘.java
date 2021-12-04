package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/22
 */
public class 水果拼盘 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int[] arr = new int[6];
            for (int i = 0; i < 6; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr);
        }
    }

    private static void cal(int[] arr) {
        int ans = 0;
        int f = arr[5];
        int e = arr[4];
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int d = arr[3];
        boolean is2 = f >= e;
        if (is2) {
            // 方案2
            int cur = Math.min(d, Math.min(b, c)) * f;
            ans += cur;
            if (cur / f < d) {
                ans += Math.min(d - cur / f, a) * e;
            }
            System.out.println(ans);
            return;
        }
        // 方案1
        ans = e * Math.min(a, d);
        if (a < d) {
            ans += Math.min(d - a, Math.min(b, c)) * f;
        }
        System.out.println(ans);
    }
}
