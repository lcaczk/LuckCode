package com.wkk.array;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/23
 */
public class LC_1893 {
    public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        int min = ranges[0][0];
        if (min > left) {
            return false;
        }
        int idxRight = ranges[0][1];
        for (int[] num : ranges) {
            int innerLeft = num[0];
            int innerRight = num[1];
            if (innerLeft > idxRight + 1) {
                return false;
            } else {
                idxRight = Math.max(idxRight, innerRight);
            }
        }
        return idxRight >= right;
    }

    private static void printMatrix(int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
//        int[][] a = {{13, 43}, {19, 20}, {32, 38}, {26, 33}, {3, 38}, {16, 31}, {26, 48}, {27, 43}, {12, 24}};
        int[][] a = {{3, 3}, {1, 1}};
        int left = 3;
        int right = 3;
        isCovered(a, left, right);
    }
}
