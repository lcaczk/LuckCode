package com.wkk.simulation.zj;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 找零 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int diff = 1024 - n;
        int count = 0;
        while (diff > 64) {
            count += diff / 64;
            diff %= 64;
        }

        while (diff > 16) {
            count += diff / 16;
            diff %= 16;
        }

        while (diff > 4) {
            count += diff / 4;
            diff %= 4;
        }
        count += diff;
        System.out.println(count);
    }
}
