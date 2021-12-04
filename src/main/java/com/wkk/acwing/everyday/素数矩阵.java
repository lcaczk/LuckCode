package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 素数矩阵 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int m = sc.nextInt();
            cal(m);
        }
    }

    private static void cal(int m) {
        // 思路：
        // 数字无特殊要求，也不要求重复:)
        // 寻找一个素数，使是适用于所有目标数量的非素数之和
        // 所以：固定数素，然后返回使用两个固定非素数，其余位补0
        // 第一个非素数 1 第二个非素数 4
        int[][] matrix = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = i; j < m; j++) {
                if (i == j) {
                    matrix[i][j] = 1;
                } else if (j == i + 1) {
                    matrix[i][j] = 4;
                }
            }
        }
        matrix[m - 1][0] = 4;
        printfMatrix(matrix);

    }

    private static void printfMatrix(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
