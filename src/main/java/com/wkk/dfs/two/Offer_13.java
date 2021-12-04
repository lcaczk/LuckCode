package com.wkk.dfs.two;

/**
 * @author weikunkun
 * @since 2021/6/29
 */
public class Offer_13 {
    int rows;
    int cols;
    int k;
    int[][] steps = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    int count = 0;
    boolean[][] visited;

    public int movingCount(int m, int n, int k) {
        this.rows = m;
        this.cols = n;
        this.k = k;
        visited = new boolean[m][n];
        dfs(0, 0);
        return count;
    }

    private void dfs(int i, int j) {
        if (!isPow(i, j) || !canMow(i, j) || visited[i][j]) {
            return;
        }
        count++;
        visited[i][j] = true;
        for (int[] step : steps) {
            int nX = step[0] + i;
            int nY = step[1] + j;
            dfs(nX, nY);
        }
    }

    private boolean isPow(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    private boolean canMow(int i, int j) {
        return cal(i) + cal(j) <= k;
    }

    private int cal(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
