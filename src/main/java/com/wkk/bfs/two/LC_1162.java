package com.wkk.bfs.two;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class LC_1162 {
    private static int[][] steps = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static int rows;
    private static int cols;

    public static int maxDistance(int[][] grid) {
        // 暴力
        // bfs
        // 遇到 0 执行bfs遇到的第一个1 为最近
        rows = grid.length;
        cols = grid[0].length;
        Queue<int[]> queue;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    boolean flag = false;
                    queue = new LinkedList<>();
                    queue.offer(new int[]{i, j});
                    int count = 0;
                    while (!queue.isEmpty()) {
                        int size = queue.size();
                        while (size-- > 0) {
                            int[] idx = queue.poll();
                            for (int[] step : steps) {
                                int nX = step[0] + idx[0];
                                int nY = step[1] + idx[1];
                                if (isPow(nX, nY) && grid[nX][nY] == 1) {
                                    max = Math.max(max, count + 1);
                                    flag = true;
                                    break;
                                } else if (isPow(nX, nY) && grid[nX][nY] == 0) {
                                    queue.offer(new int[]{nX, nY});
                                }
                            }
                        }
                        count++;
                        if (flag) {
                            break;
                        }
                    }
                    if (flag) {
                        break;
                    }
                }
            }
        }
        return max;
    }

    private static boolean isPow(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }


    public static int maxDistanceII(int[][] grid) {
        // 方向向量
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        // 由于题目中给出了 grid 的范围，因此不用做输入检查
        int N = grid.length;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == 1) {
                    // 把陆地添加到队列中
                    queue.add(getIndex(i, j, N));
                }
            }
        }

        int size = queue.size();
        if (size == 0 || size == N * N) {
            return -1;
        }

        boolean[][] visited = new boolean[N][N];
        int step = 0;
        while (!queue.isEmpty()) {
            // 注意：先把当前队列的长度保存下来
            int currentQueueSize = queue.size();
            for (int i = 0; i < currentQueueSize; i++) {
                Integer head = queue.poll();
                int currentX = head / N;
                int currentY = head % N;

                for (int[] direction : directions) {
                    int newX = currentX + direction[0];
                    int newY = currentY + direction[1];
                    if (inArea(newX, newY, N) && !visited[newX][newY] && grid[newX][newY] == 0) {
                        // 赋值成为一个不等于 0 的整数均可，因为后续逻辑只关心海洋（0）
                        // 也可以直接通过标识位标识
                        visited[newX][newY] = true;
                        queue.add(getIndex(newX, newY, N));
                    }
                }
            }
            step++;
        }
        // 注意：由于最后一步，没有可以扩散的的区域，但是 step 加了 1，故在退出循环的时候应该减 1
        return step - 1;
    }

    /**
     * @param x    二维表格单元格横坐标
     * @param y    二维表格单元格纵坐标
     * @param cols 二维表格列数
     * @return
     */
    private static int getIndex(int x, int y, int cols) {
        return x * cols + y;
    }

    /**
     * @param x 二维表格单元格横坐标
     * @param y 二维表格单元格纵坐标
     * @param N 二维表格行数（列数）
     * @return 是否在二维表格有效范围内
     */
    private static boolean inArea(int x, int y, int N) {
        return 0 <= x && x < N && 0 <= y && y < N;
    }


    public static void main(String[] args) {
        int[][] grid = {{1, 0, 1}, {0, 0, 0}, {1, 0, 1}};
        System.out.println(maxDistanceII(grid));
    }
}
