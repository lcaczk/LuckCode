package com.wkk.dfs;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class AC_1116 {
    private static int total;
    private static int rows;
    private static int cols;
    private static int ans;
    private static int[][] dir = new int[][]{
            {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
            {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            rows = sc.nextInt();
            cols = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean[][] visited = new boolean[rows][cols];
            int pos = 1;
            ans = 0;
            total = rows * cols;
            dfs(x, y, pos, visited);
            System.out.println(ans);
        }
    }

    private static void dfs(int x, int y, int curNums, boolean[][] visited) {
        if (curNums == total) {
            ans++;
            return;
        }
        for (int[] step : dir) {
            x += step[0];
            y += step[1];
            if (!isPos(x, y) || visited[x][y]) {
                continue;
            }
            visited[x][y] = true;
            dfs(x, y, curNums + 1, visited);
            visited[x][y] = false;
        }
    }

    private static boolean isPos(int x, int y) {
        return (x >= 0 && x < rows) && (y >= 0 && y < cols);
    }
}
