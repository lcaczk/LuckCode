package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class LC_5776 {
    private static int rows;
    private static int cols;

    public static boolean findRotation(int[][] mat, int[][] target) {
        rows = mat.length;
        cols = mat[0].length;
        if (judege(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            if (i == 0) {
                rotate1(mat);
                if (judege(mat, target)) {
                    return true;
                }
            } else if (i == 1) {
                rotate2(mat);
                if (judege(mat, target)) {
                    return true;
                }
            } else {
                rotate3(mat);
                if (judege(mat, target)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean judege(int[][] mat, int[][] target) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (mat[i][j] != target[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    // 1
    public static void rotate1(int[][] matrix) {
        int n = matrix.length;
        // 先以对角线（左上-右下）为轴进行翻转
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // 再对每一行以中点进行翻转
        int mid = n >> 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < mid; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
    // 2
    public static void rotate2(int[][] matrix) {
        for (int i = 0; i < rows / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[rows - i - 1];
            matrix[rows - i - 1] = tmp;
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols / 2; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][cols - j - 1];
                matrix[i][cols - j - 1] = tmp;
            }
        }
    }

    // 3
    public static void rotate3(int[][] matrix) {
        for (int i = 0; i < rows; i++) {
            for (int j = i; j < cols; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int i = 0; i < rows / 2; i++) {
            int[] tmp = matrix[i];
            matrix[i] = matrix[rows - i - 1];
            matrix[rows - i - 1] = tmp;
        }

    }

    public static void main(String[] args) {
        int[][] matrix = {{0, 0, 0}, {0, 0, 1}, {0, 0, 1}};
        int[][] tmp = {{1, 0}, {0, 1}};
        rows = matrix.length;
        cols = matrix[0].length;
        rotate1(matrix);
        print(matrix);

    }

    private static void print(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

    }
}
