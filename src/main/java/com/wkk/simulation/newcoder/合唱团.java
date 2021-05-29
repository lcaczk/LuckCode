package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * 基本思路参考LC 152
 * 在其基础上 先定了选择几个人 以及 选人的范围
 *
 * @author weikunkun
 * @since 2021/5/24
 */
public class 合唱团 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNextInt()) {
            int n = cin.nextInt(); 			// n 个学生
            int[] arr = new int [n+1];
            for (int i = 1; i <=n ; i++) {
                arr[i] = cin.nextInt();
            }
            int K = cin.nextInt();			  // 选出K个
            int d = cin.nextInt();			  // 两个学生的位置编号的差不超过 d
            long[][] fmax = new long[K+1][n+1]; // 记录最大乘积
            long[][] fmin = new long[K+1][n+1]; // 记录最小乘积
            // fmax[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最大乘积；
            // fmin[k][i]表示 : 当选中了k个学生，并且以第i个学生为结尾，所产生的最小乘积；
            //初始化第一行
            long  res = Integer.MIN_VALUE; // 记得用Long类型，考虑数值范围
            for (int i = 1; i <= n; i++) { // 以第i个小朋友为结尾
                fmax[1][i] = arr[i];
                fmin[1][i] = arr[i];
                for (int k = 2; k <= K; k++) {
                    int j = i - 1;
                    while (i - j <= d && j > 0) {
                        fmax[k][i] = Math.max(fmax[k][i], Math.max(fmin[k-1][j] * arr[i], fmax[k-1][j] * arr[i]));
                        fmin[k][i] = Math.min(fmin[k][i], Math.min(fmin[k-1][j] * arr[i], fmax[k-1][j] * arr[i]));
                        j--;
                    }
                }
                res = Math.max(res, fmax[K][i]);

            }
            System.out.println(res);
        }
    }
}
