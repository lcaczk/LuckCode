package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/28
 */
public class 被3整除 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int second = sc.nextInt();
        // 1 0 0 1 0 0 1
        System.out.println(count(first, second));
    }

    private static int count(int l, int r) {
        int result=0;

        for (int i = l; i <= r; i++){
            if (i % 3 != 1) result++;
        }
        return result;
    }
}
