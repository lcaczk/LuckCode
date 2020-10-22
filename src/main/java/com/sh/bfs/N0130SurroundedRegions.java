package com.sh.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：130.被围绕的区域
 * 题目链接：https://leetcode-cn.com/problems/surrounded-regions/
 * <p>
 * 题目描述：
 * 给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
 * 找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
 * <p>
 * 示例:
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * 运行你的函数后，矩阵变为：
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * <p>
 * 解释:
 * 被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被
 * 填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 并查集
 */
class N0130SurroundedRegions {
    public void solve(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int h = board.length;
        int w = board[0].length;
        boolean[][] visited = new boolean[h][w];
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O' && !visited[i][j]) {
                    board[i][j] = 'X';
                    visited[i][j] = true;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i, j});
                    // 记录当前一次遍历位置，用于还原
                    List<int[]> tmpVisited = new LinkedList<>();
                    tmpVisited.add(new int[]{i, j});
                    boolean flag = false;
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        // 边界判断
                        if (row == 0 || row == h - 1 || col == 0 || col == w - 1) {
                            flag = true;
                        }
                        // 当前位置4个方向遍历
                        if (row - 1 >= 0 && board[row - 1][col] == 'O' && !visited[row - 1][col]) {
                            queue.add(new int[]{row - 1, col});
                            tmpVisited.add(new int[]{row - 1, col});
                            visited[row - 1][col] = true;
                            board[row - 1][col] = 'X';
                        }
                        if (row + 1 < h && board[row + 1][col] == 'O' && !visited[row + 1][col]) {
                            queue.add(new int[]{row + 1, col});
                            tmpVisited.add(new int[]{row + 1, col});
                            visited[row + 1][col] = true;
                            board[row + 1][col] = 'X';
                        }
                        if (col - 1 >= 0 && board[row][col - 1] == 'O' && !visited[row][col - 1]) {
                            queue.add(new int[]{row, col - 1});
                            tmpVisited.add(new int[]{row, col - 1});
                            visited[row][col - 1] = true;
                            board[row][col - 1] = 'X';
                        }
                        if (col + 1 < w && board[row][col + 1] == 'O' && !visited[row][col + 1]) {
                            queue.add(new int[]{row, col + 1});
                            tmpVisited.add(new int[]{row, col + 1});
                            visited[row][col + 1] = true;
                            board[row][col + 1] = 'X';
                        }
                    }
                    // 如果超过边界，还原board
                    if (flag) {
                        for (int[] t : tmpVisited) {
                            board[t[0]][t[1]] = 'O';
                        }
                    }
                }
            }
        }
    }


    public void solve2(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int h = board.length;
        int w = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                // 判断边缘的’O‘
                if (board[i][j] == 'O' && (i == 0 || i == h - 1 || j == 0 || j == w - 1)) {
                    // 将边缘的’O‘置为’T‘标识，然后BFS遍历所有相连的’O‘都置为’T‘
                    board[i][j] = 'T';
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        // BFS四个方向的’O‘
                        if (row - 1 >= 0 && board[row - 1][col] == 'O') {
                            queue.add(new int[]{row - 1, col});
                            board[row - 1][col] = 'T';
                        }
                        if (row + 1 < h && board[row + 1][col] == 'O') {
                            queue.add(new int[]{row + 1, col});
                            board[row + 1][col] = 'T';
                        }
                        if (col - 1 >= 0 && board[row][col - 1] == 'O') {
                            queue.add(new int[]{row, col - 1});
                            board[row][col - 1] = 'T';
                        }
                        if (col + 1 < w && board[row][col + 1] == 'O') {
                            queue.add(new int[]{row, col + 1});
                            board[row][col + 1] = 'T';
                        }
                    }
                }
            }
        }
        // 所有与边缘相连的’O‘都被置为了’T‘，剩余的’O‘都是中间被’X‘包围的
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    public static void main(String[] args) {
        N0130SurroundedRegions solution = new N0130SurroundedRegions();
        char[][] board = new char[][]{
                {'O', 'X', 'X', 'O', 'X'},
                {'X', 'O', 'O', 'X', 'O'},
                {'X', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O'},
                {'X', 'X', 'O', 'X', 'O'}
        };
        for (char[] s : board) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println('=');
        solution.solve(board);
        for (char[] s : board) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println('=');
        System.out.println('=');
        System.out.println('=');

        char[][] board2 = new char[][]{
                {'X', 'O', 'X', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'X', 'O', 'O', 'O', 'O', 'X', 'O'},
                {'O', 'O', 'O', 'O', 'X', 'O', 'X'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'O', 'O', 'O', 'O', 'O', 'O'},
                {'O', 'X', 'O', 'O', 'O', 'O', 'O'}
        };
        for (char[] s : board2) {
            System.out.println(Arrays.toString(s));
        }
        System.out.println('=');
        solution.solve(board2);
        for (char[] s : board2) {
            System.out.println(Arrays.toString(s));
        }
    }
}