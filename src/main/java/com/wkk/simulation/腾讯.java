package com.wkk.simulation;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/14
 */
public class 腾讯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int times = sc.nextInt();
        while (times-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            int ans = genNum(left, right);
            System.out.println(ans);
        }
    }

    private static int genNum(int left, int right) {
        int base = 0;
        int diff = 1;
        if (judeOdd(left)) {
            diff = -1;
            base = -left;
        } else {
            base = left;
        }
        int distance = right - left;
        if (distance == 0) {
            return base;
        }
        if (judeOdd(right)) {
            right = -right;
        }
        if (distance % 2 == 1) {
            return base + right + ((distance - 1) / 2) * diff;
        } else {
            return base + ((distance)/2) * diff;
        }
    }

    private static boolean judeOdd(int num) {
        return num % 2 == 1;
    }
}
