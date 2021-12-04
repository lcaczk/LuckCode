package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/10
 */
public class 数字翻转 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        System.out.println(cal(first, second));
    }

    private static int cal(int first, int second) {
        first = revert(first);
        second = revert(second);
        return revert(first + second);
    }

    private static int revert(int num) {
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 10);
            num /= 10;
        }
        return Integer.parseInt(sb.toString());
    }
}
