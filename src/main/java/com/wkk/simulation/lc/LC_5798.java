package com.wkk.simulation.lc;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/27
 */
public class LC_5798 {
    public static int[][] rotateGrid(int[][] grid, int k) {
        // 依次获取每一圈
        // 转为一维 然后旋转
        // 然后再次放回
        int rows = grid.length;
        int cols = grid[0].length;
        int circle = Math.min(rows, cols) / 2;
        for (int i = 0; i < circle; i++) {
            int innerRows = rows - 2 * i;
            int innerCols = cols - 2 * i;
            int[] layer = getRow(grid, innerRows, innerCols, k, i);
            putLayer(grid, layer, innerRows, innerCols, i);
        }
        return grid;
    }

    /**
     * 转为一维并旋转
     * 螺旋逆向输出
     *
     * @param grid
     * @return
     */
    private static int[] getRow(int[][] grid, int rows, int cols, int k, int idx) {
        int l = idx;
        int t = idx;
        int r = idx + cols - 1;
        int b = idx + rows - 1;
        List<Integer> list = new ArrayList<>();
        for (int i = l; i <= b; i++) {
            list.add(grid[i][l]);
        }
        l++;
        for (int i = l; i <= r; i++) {
            list.add(grid[b][i]);
        }
        b--;
        for (int i = b; i >= t; i--) {
            list.add(grid[i][r]);
        }
        r--;
        for (int i = r; i >= l; i--) {
            list.add(grid[t][i]);
        }
        int[] array = list.stream().mapToInt(Integer::intValue).toArray();
        // 旋转
        int n = array.length;
        System.out.println("旋转前");
        printArray(array);
        k %= n;
        k = n - k;
        swap(array, 0, k - 1);
        swap(array, k , array.length - 1);
        swap(array, 0, array.length - 1);
        System.out.println("旋转后");
        printArray(array);
        return array;
    }

    private static void swap(int[] array, int left, int right) {
        while (left < right) {
            int tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    /**
     * 重新放回
     * 螺旋逆向放回
     * @param grid
     * @param layer
     */
    private static void putLayer(int[][] grid, int[] layer, int rows, int cols, int idx) {
        int l = idx;
        int t = idx;
        int r = idx + cols - 1;
        int b = idx + rows - 1;
        int k = 0;
        for (int i = t; i <= b; i++) {
            grid[i][l] = layer[k++];
        }
        l++;
        for (int i = l; i <= r; i++) {
            grid[b][i] = layer[k++];
        }
        b--;
        for (int i = b; i >= t; i--) {
            grid[i][r] = layer[k++];
        }
        r--;
        for (int i = r; i >= l; i--) {
            grid[t][i] = layer[k++];
        }

    }

    private static void printMatrix(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void printArray(int[] array) {
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3, 4}, {16, 1, 2, 5}, {15, 8, 3, 6},
                {14, 7, 4, 7}, {13, 6, 5, 8}, {12, 11, 10, 9}};
        int row = matrix.length;
        int col = matrix[0].length;
        int k = 1;
        rotateGrid(matrix, k);
        System.out.println();
        printMatrix(matrix);

    }
}
