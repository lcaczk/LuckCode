package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/18
 */
public class AC_3972 {
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
        cal(matrix, rows, cols);
    }

    private static void cal(int[][] matrix, int rows, int cols) {
        long sum = 0;
        for (int i = 0; i < rows; i++) {
            sum += countRows(matrix, i, cols, 0);
            sum += countRows(matrix, i, cols, 1);
        }

        for (int i = 0; i < cols; i++) {
            sum += countCols(matrix, rows, i, 0);
            sum += countCols(matrix, rows, i, 1);
        }
        System.out.println(sum - rows * cols);
    }

    private static long countRows(int[][] matrix, int row, int cols, int target) {
        long count = 0;
        for (int i = 0; i < cols; i++) {
            if (matrix[row][i] == target) {
                count++;
            }
        }
        return (long) (Math.pow(2, count) - 1);
    }

    private static long countCols(int[][] matrix, int rows, int col, int target) {
        long count = 0;
        for (int i = 0; i < rows; i++) {
            if (matrix[i][col] == target) {
                count++;
            }
        }
        return (long) (Math.pow(2, count) - 1);
    }
}
