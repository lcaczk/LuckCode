package com.wkk.simulation.zj;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            String str = sc.next();
            cal(str);
        }
    }

    private static void cal(String str) {
        // OOO -> OO
        // aabb -> aab
        // 先处理第一种
        // 后处理第二种
        int i = 0;
        StringBuilder tmp = new StringBuilder(str);
        while (i < tmp.length() - 2) {
            char first = tmp.charAt(i);
            char second = tmp.charAt(i + 1);
            char third = tmp.charAt(i + 2);
            if (first == second && second == third) {
                tmp.deleteCharAt(i + 2);
            } else {
                i += 1;
            }
        }
        i = 0;
        while (i < tmp.length() - 3) {
            char a = tmp.charAt(i);
            char b = tmp.charAt(i + 1);
            char c = tmp.charAt(i + 2);
            char d = tmp.charAt(i + 3);
            if (a == b && c == d) {
                tmp.deleteCharAt(i + 3);
            } else {
                i += 1;
            }
        }
        System.out.println(tmp.toString());
    }
}
