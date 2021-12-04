package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class 照镜子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
        int h = cal(matrix, rows, cols);
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    // 求高度
    private static int cal(int[][] matrix, int rows, int cols) {
        if (rows % 2 == 1) {
            return rows;
        }
        for (int i = 0; i < rows / 2; i++) {
            if (matrix[i][0] != matrix[rows - i - 1][0]) {
                return rows;
            }
        }
        return cal(matrix, rows / 2, cols);
    }
}
