package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/13
 */
public class 数字矩阵 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    matrix[i][j] = sc.nextInt();
                }
            }
            int ans = cal(matrix, m, n);
            System.out.println(ans);
        }
    }

    private static int cal(int[][] matrix, int rows, int cols) {
        int ans = 0;
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ans += Math.abs(matrix[i][j]);
                min = Math.min(Math.abs(matrix[i][j]), min);
                if (matrix[i][j] < 0) {
                    cnt++;
                }
            }
        }
        if (cnt % 2 == 0) {
            return ans;
        } else {
            return ans - 2 * min;
        }
    }
}
