package com.wkk.interview.bytedance2020;

/**
 * @Time: 2020/7/25上午9:56
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_NumberOfClosedIslands {
    public int closedIsland(int[][] grid) {
        int row = grid.length;
        if (row <= 2) { //不超过2行，不能形成岛屿
            return 0;
        }

        int column = grid[0].length;
        if (column <= 2) { //不超过2例，不能形成岛屿
            return 0;
        }

        for (int x = 0; x < row; x++) { //边界陆地（非法）蔓延，标记
            area(grid, row, column, x, 0);
            area(grid, row, column, x, column - 1);
        }

        for (int y = 1; y < column - 1; y++) { //边界陆地（非法）蔓延，标记
            area(grid, row, column, 0, y);
            area(grid, row, column, row - 1, y);
        }

        int count = 0;
        for (int x = 1; x < row - 1; x++) {
            for (int y = 1; y < column - 1; y++) {
                if (grid[x][y] != 0) {
                    continue;
                }

                area(grid, row, column, x, y); //内部陆地（岛屿）蔓延，标记
                count++;
            }
        }

        return count;
    }

    private void area(int[][] grid, int row, int column, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= column) {
            return;
        }

        if (grid[x][y] != 0) {
            return;
        }
        grid[x][y] = 2; //标记查询过的陆地

        area(grid, row, column, x, y + 1);
        area(grid, row, column, x, y - 1);
        area(grid, row, column, x + 1, y);
        area(grid, row, column, x - 1, y);
    }
}
