package com.wkk.acwing.dp;

import java.util.Scanner;

/**
 * 1015. 摘花生
 * @author weikunkun
 * @since 2021/4/18
 */
public class AC_1015 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            int cols = sc.nextInt();
            int rows = sc.nextInt();
            int[][] matrix = new int[cols][rows];
            int[][] dp = new int[cols][rows];
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            dp[0][0] = matrix[0][0];
            for (int i = 0; i < cols; i++) {
                for (int j = 0; j < rows; j++) {
                    if (i == 0 || j == 0) {
                        dp[i][j] = matrix[i][j];
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]) + matrix[i][j];
                    }
                }
            }
            System.out.println(dp[cols-1][rows-1]);
        }
    }

}
