package com.wkk.twopointer;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/28
 */
public class AC_2816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] first = new int[n1];
        int[] second = new int[n2];
        boolean ans = cal(first, second, n1, n2);
        String res = ans ? "Yes" : "No";
        System.out.println(res);
    }

    private static boolean cal(int[] first, int[] second, int n, int m) {
        // first  小  n
        // second 大  m
        int i = 0;
        int j = 0;
        while (i < m && j < n) {
            if (second[i] == first[j]) {
                j++;
            }
            i++;
        }
        return j == n;
    }
}
