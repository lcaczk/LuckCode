package com.wkk.dfs.two;

/**
 * @author weikunkun
 * @since 2021/6/9
 */
public class LC_79 {
    private int rows;
    private int cols;
    private int[][] steps = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        this.rows = board.length;
        this.cols = board[0].length;
        this.visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs (char[][] board, int i, int j, String word, int idx) {
        if (idx >= word.length()) {
            return true;
        }
        if (!isPow(i, j) || word.charAt(idx) != board[i][j] || visited[i][j]) {
            return false;
        }
        visited[i][j] = true;
        boolean res = false;
        for (int[] step : steps) {
            int nX = step[0] + i;
            int nY = step[1] + j;
            res |= dfs(board, nX, nY, word, idx + 1);
        }
        visited[i][j] = false;
        return res;

    }

    private boolean isPow(int i, int j) {
        return  (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    public static void main(String[] args) {
        LC_79 lc_79 = new LC_79();
        char[][] matrix = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(lc_79.exist(matrix, "SEE"));
    }
}
