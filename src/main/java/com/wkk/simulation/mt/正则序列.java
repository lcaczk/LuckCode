package com.wkk.simulation.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class 正则序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(arr, n));
    }

    private static int cal(int[] score, int n) {
        // 贪心排序
        // 不在 1 - n 的数值 变换为最接近的
        // 在区间的 且重复的，变换为最近的
        Arrays.sort(score);
        int[] base = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = i + 1;
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += Math.abs(score[i] - base[i]);
        }
        return sum;

    }
}
