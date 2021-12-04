package com.wkk.simulation.ali;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/22
 */
public class 完美对 {
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
        int count = 0;

        System.out.println(count);
    }
}
