package com.wkk.dfs.two;

/**
 * 安卓系统手势解锁
 * @author weikunkun
 * @since 2021/6/1
 */
public class LC_351 {
    private int count = 0;
    private int m, n;
    private int[][] step = new int[][] {{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,1},{1,-1},{-1,-1},{-1,2},{1,2},{-2,1},{2,1},{-1,-2},{1,-2},{-2,-1},{2,-1}};

    /**
     * 如果走L形的move，我们不认为它经过任何其他的格子。
     *
     * 本题是典型的DFS。我们从任意点开始，每个回合有16种移动的选择：
     * 上、下、左、右、左上、左下、右上、右下、
     * 左上上、右上上、左下下、右下下、左左上、左左下、右右上、右右下。
     *
     * 特别地，对于前8种move而言，
     * 如果走一步遇到的格子是已经访问过的，根据规则，可以再朝同方向走一步（算作同一次操作）。
     * 如果走一步遇到的格子是没有访问过的，则不能这么做。
     * @param m
     * @param n
     * @return
     */
    public int numberOfPatterns(int m, int n) {
        this.m = m;
        this.n = n;
        boolean[][] visited = new boolean[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                visited[i][j] = true;
                dfs(i, j, 1, visited);
                visited[i][j] = false;
            }
        }
        return count;
    }

    private void dfs(int x, int y, int r, boolean[][] visited) {
        if (r >= m && r <= n) {
            count++;
        }
        if (r > n) {
            return;
        }
        for (int k = 0; k < step.length; k++) {
            int i = x + step[k][0];
            int j = y + step[k][1];
            if (i < 0 || i >= 3 || j < 0 || j >= 3) {
                continue;
            }
            if (!visited[i][j]) {
                visited[i][j] = true;
                dfs(i, j, r + 1, visited);
                visited[i][j] = false;
            } else {
                i = i + step[k][0];
                j = j + step[k][1];
                if (i < 0 || i >= 3 || j < 0 || j >= 3) {
                    continue;
                }
                if (visited[i][j]) {
                    continue;
                }
                visited[i][j] = true;
                dfs(i, j, r+1, visited);
                visited[i][j] = false;
            }
        }
    }
}
