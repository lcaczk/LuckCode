package com.sh.bfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：200.岛屿数量
 * 题目链接：https://leetcode-cn.com/problems/number-of-islands/
 * <p>
 * 题目描述：
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * 示例 1：
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 * <p>
 * 提示：
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] 的值为 '0' 或 '1'
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集
 */
class N0200NumberOfIslands {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int num = 0;
        int h = grid.length;
        int w = grid[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    num++;
                    visited[i][j] = true;
                    Queue<Integer> queue = new LinkedList<>();
                    queue.add(i * w + j);
                    while (!queue.isEmpty()) {
                        // 当前位置
                        int cur = queue.poll();
                        int row = cur / w;
                        int col = cur % w;
                        // 当前位置4个方向遍历
                        if (row - 1 >= 0 && grid[row - 1][col] == '1' && !visited[row - 1][col]) {
                            queue.add((row - 1) * w + col);
                            visited[row - 1][col] = true;
                        }
                        if (row + 1 < h && grid[row + 1][col] == '1' && !visited[row + 1][col]) {
                            queue.add((row + 1) * w + col);
                            visited[row + 1][col] = true;
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1' && !visited[row][col - 1]) {
                            queue.add(row * w + col - 1);
                            visited[row][col - 1] = true;
                        }
                        if (col + 1 < w && grid[row][col + 1] == '1' && !visited[row][col + 1]) {
                            queue.add(row * w + col + 1);
                            visited[row][col + 1] = true;
                        }
                    }
                }
            }
        }
        return num;
    }
}