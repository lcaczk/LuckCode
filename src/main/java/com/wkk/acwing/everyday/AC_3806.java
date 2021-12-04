package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/16
 */
public class AC_3806 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String a = sc.nextLine();
            cal(n, a);
        }
    }

    private static void cal(int n, String str) {
        // 寻找第一个拐点
        int idx = n - 1;
        StringBuilder sb = new StringBuilder();
        char[] arr = str.toCharArray();
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                idx = i;
                break;
            }
            sb.append(arr[i]);
        }
        for (int i = idx + 1; i < n; i++) {
            sb.append(arr[i]);
        }
        System.out.println(sb.toString());
    }
}
