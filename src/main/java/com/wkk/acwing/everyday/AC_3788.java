package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/9
 */
public class AC_3788 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String num = sc.nextLine();
            cal(num);
        }
    }

    private static void cal(String num) {
        int n = num.length();
        if (n == 1) {
            System.out.println(Integer.parseInt(num) + 1);
        } else {
            int first = num.charAt(0) - '0' + 1;
            int cur = Integer.parseInt(num);
            int next = first * (int) Math.pow(10, n - 1);
            System.out.println(next - cur);
        }
    }
}
