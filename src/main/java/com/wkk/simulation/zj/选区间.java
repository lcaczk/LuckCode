package com.wkk.simulation.zj;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 选区间 {
    public static void main(String[] args) {
        // 先通过排列组合 获取所有集合
        // 然后按照规则计算
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        long res = 0;
        for (int i = 0; i <= 100; i++) {
            int realMin = Integer.MAX_VALUE; //真正的区间最小值
            long sum = 0;
            for (int j = 0; j < n; j++) {
                if (a[j] >= i) {
                    sum += a[j];
                    realMin = Math.min(realMin, a[j]);
                } else {
                    res = Math.max(res, realMin * sum);
                    sum = 0;
                    realMin = Integer.MAX_VALUE;
                }
            }
            res = Math.max(res, realMin * sum);
        }
        System.out.println(res);
    }
}
