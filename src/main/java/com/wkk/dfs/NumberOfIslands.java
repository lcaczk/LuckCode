package com.wkk.dfs;

/**
 * @Time: 20-3-24上午8:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class NumberOfIslands {
    private static final int[][] DIRS = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final char L = '1', W = '0';

    public int numIslands(char[][] grid){
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == L) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private void dfs(char[][] grid, int x, int y) {
        // 边界判断
        if (x < 0  || x > grid.length-1 || y < 0 || y > grid[0].length-1) {
            return;
        }
        if(grid[x][y] == L){
            grid[x][y] = W;
            for (int[] dir : DIRS) {
                dfs(grid, x+dir[0], y+dir[1]);
            }
        }
    }
}
