package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/11
 */
public class AC_3955 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            String a = sc.nextLine();
            char[] array = a.toCharArray();
            int n = array.length;
            cal(array, n);
        }
    }

    private static void cal(char[] array, int n) {
        int lower = 0;
        int upper = 0;
        for (char c : array) {
            if (Character.isLowerCase(c)) {
                lower++;
            } else {
                upper++;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (lower >= upper) {
            for (char c : array) {
                sb.append(Character.toLowerCase(c));
            }
            System.out.println(sb.toString());
        } else {
            for (char c : array) {
                sb.append(Character.toUpperCase(c));
            }
            System.out.println(sb.toString());
        }
    }
}
