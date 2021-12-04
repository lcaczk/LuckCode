package com.wkk.dfs.two;

/**
 * 329. 矩阵中的最长递增路径
 *
 * @author weikunkun
 * @since 2021/7/17
 */
public class LC_329 {
    private int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int max = Integer.MIN_VALUE;
    private int rows;
    private int cols;

    public int longestIncreasingPath(int[][] matrix) {
        this.rows = matrix.length;
        this.cols = matrix[0].length;
        boolean[][] visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                dfs(matrix, i, j, 1, visited, Integer.MIN_VALUE);
            }
        }
        return max;
    }

    private void dfs(int[][] matrix, int i, int j, int depth, boolean[][] visited, int preNum) {
        if (!isPos(i, j) || visited[i][j] || preNum >= matrix[i][j]) {
            return;
        }
        max = Math.max(max, depth);
        visited[i][j] = true;
        for (int[] step : steps) {
            int nX = step[0] + i;
            int nY = step[1] + j;
            dfs(matrix, nX, nY, depth + 1, visited, matrix[i][j]);
        }
        visited[i][j] = false;
    }

    private boolean isPos(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    public static void main(String[] args) {
        int[][] matrix = {{9, 9, 4}, {6, 6, 8}, {2, 2, 1}};
        LC_329 lc_329 = new LC_329();
        System.out.println(lc_329.longestIncreasingPath(matrix));
    }
}
