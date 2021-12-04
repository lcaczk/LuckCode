package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class Fibonacci数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        System.out.println(step(num));
    }

    private static int step(int num) {
        int a = 0;
        int b = 1;
        while (b < num) {
            int c = b;
            b = a + b;
            a = c;
        }
        int disA = num - a;
        int disB = b - num;
        return Math.min(disB, disA);
    }
}
