package com.wkk.simulation.bd;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/19
 */
public class 最小值 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        long k = sc.nextLong();
        long total =(long) m * n;
        long diff = total - k;
        int max = Math.max(m, n);
        if (diff % max == 0) {
            System.out.println(diff / max);
        } else {
            System.out.println(diff / max + 1);
        }
    }
}
