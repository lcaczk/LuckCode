package com.wkk.bfs.two;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 池塘计数
 * 统计共有多少个子图 （dfs、 bfs、uf）均可
 * @author weikunkun
 * @since 2021/8/2
 */
public class AC_1097 {
    private static int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1},
            {1, -1}, {1, 1}, {-1, 1}, {-1, -1}};
    private static int rows;
    private static int cols;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        rows = Integer.parseInt(line[0]);
        cols = Integer.parseInt(line[1]);
        char[][] graph = new char[rows][cols];
        char[] tmp;
        for (int i = 0; i < rows; i++) {
            tmp = sc.nextLine().toCharArray();
            graph[i] = tmp;
        }
        cal(graph, rows, cols);
    }

    private static void cal(char[][] graph, int rows, int cols) {
        Queue<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[rows][cols];
        int[] p;
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j] && graph[i][j] == 'W') {
                    count++;
                    visited[i][j] = true;
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        p = queue.poll();
                        int x = p[0];
                        int y = p[1];
                        for (int[] step : steps) {
                            int nx = step[0] + x;
                            int ny = step[1] + y;
                            if (isPos(nx, ny) && !visited[nx][ny] && graph[nx][ny] == 'W') {
                                queue.offer(new int[]{nx, ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    private static boolean isPos(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }

    private static void printMatrix(char[][] graph, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }
}
