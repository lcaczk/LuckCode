package com.wkk.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/29
 */
public class Offer_13 {
    int rows;
    int cols;
    int k;
    int[][] steps = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
    public int movingCount(int m, int n, int k) {
        int count = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        boolean[][] visited = new boolean[m][n];
        rows = m;
        cols = n;
        this.k = k;
        visited[0][0] = true;
        int[] p;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                p = queue.poll();
                for (int[] step : steps) {
                    int nX = p[0] + step[0];
                    int nY = p[1] + step[1];
                    if (isPow(nX, nY) && canMow(nX, nY) && !visited[nX][nY]) {
                        visited[nX][nY] = true;
                        queue.offer(new int[]{nX, nY});
                    }
                }
                count++;
            }
        }
        return count;
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
