package com.wkk.dfs.two;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class LC_417 {
    private int[][] step = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int rows;
    private int cols;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> res = new ArrayList<>();
        if(heights == null || heights.length == 0) {
            return res;
        }
        rows = heights.length;
        cols = heights[0].length;
        boolean[][] first = new boolean[rows][cols];
        boolean[][] second = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            dfs(heights, i, 0, first);
            dfs(heights, i, cols - 1, first);
        }

        for (int i = 0; i < cols; i++) {
            dfs(heights, 0, i, second);
            dfs(heights, rows - 1, i, second);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first[i][j] && second[i][j]) {
                    res.add(new ArrayList<>(Arrays.asList(i, j)));
                }
            }
        }
        return res;

    }

    private void dfs(int[][] matrix, int i, int j, boolean[][] visited) {
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        for (int k = 0; k < 4; k++) {
            int newI = i + step[k][0];
            int newJ = j + step[k][1];
            if (!isNormal(newI, newJ) || visited[newI][newJ] || matrix[i][j] < matrix[newI][newJ]) {
                continue;
            }
            dfs(matrix, newI, newJ, visited);
        }

    }

    private boolean isNormal(int i, int j) {
        return (i >= 0 && i < rows) && (j >= 0 && j < cols);
    }
}
