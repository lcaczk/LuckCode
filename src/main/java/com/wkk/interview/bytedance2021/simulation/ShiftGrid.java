package com.wkk.interview.bytedance2021.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/4/7
 */
public class ShiftGrid {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int rows = grid.length;
        int cols = grid[0].length;
        while (k > 0) {
            k--;
            int previous = grid[grid.length - 1][grid[0].length - 1];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int temp = grid[i][j];
                    grid[i][j] = previous;
                    previous = temp;
                }
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int[] row : grid) {
            List<Integer> temp = Arrays.stream(row).boxed().collect(Collectors.toList());
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3},
                {4, 5, 6}, {7, 8, 9}};
        ShiftGrid lc_xx = new ShiftGrid();
        lc_xx.shiftGrid(matrix, 1);
    }

}
