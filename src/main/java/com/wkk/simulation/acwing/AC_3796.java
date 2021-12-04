package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/7
 */
public class AC_3796 {
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int num = sc.nextInt();
            max = Integer.MIN_VALUE;
            cal(num);
        }
    }

    private static void cal(int num) {
        // 回溯
        String val = String.valueOf(num);
        int n = val.length();
        char[] arr = val.toCharArray();
        dfs(arr, 0, new StringBuilder(), n);
        if (max == Integer.MIN_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(n - max);
        }
    }

    private static void dfs(char[] arr, int idx, StringBuilder sb, int n) {
        if (idx > n || sb.charAt(0) == '0') {
            return;
        }
        if (sb.length() != 0) {
            int num = Integer.parseInt(sb.toString());
            int pow = (int) Math.sqrt(num);
            if (pow * pow == num) {
                max = Math.max(max, sb.length());
            }
        }
        for (int i = idx; i < n; i++) {
            sb.append(arr[i]);
            dfs(arr, i + 1, sb, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
