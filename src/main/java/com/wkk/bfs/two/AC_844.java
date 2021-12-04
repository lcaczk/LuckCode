package com.wkk.bfs.two;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/14
 */
public class AC_844 {
    private static int[][] steps = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    private static int rows;
    private static int cols;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        rows = sc.nextInt();
        cols = sc.nextInt();
        int[][] martrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                martrix[i][j] = sc.nextInt();
            }
        }
        cal(martrix, rows, cols);
    }

    private static void cal(int[][] martrix, int rows, int cols) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        int m = rows - 1;
        int n = cols - 1;
        int[] cur;
        int[][] dp = new int[rows][cols];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                cur = queue.poll();
                for (int[] step : steps) {
                    int x = cur[0] + step[0];
                    int y = cur[1] + step[1];
                    if (isPos(x, y) && dp[x][y] == 0 && martrix[x][y] == 0) {
                        queue.offer(new int[]{x, y});
                        dp[x][y] = dp[cur[0]][cur[1]] + 1;
                    }
                }
            }
        }
        System.out.println(dp[m][n]);
    }

    private static boolean isPos(int x, int y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < cols);
    }

}
