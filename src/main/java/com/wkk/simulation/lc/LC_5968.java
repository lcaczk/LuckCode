package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2022/1/2
 */
public class LC_5968 {
    public static int numberOfBeams(String[] bank) {
        int rows = bank.length;
        int cols = bank[0].length();
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = Integer.parseInt(String.valueOf(bank[i].charAt(j)));
            }
        }

        int pre = 1;
        int level = 0;
        int sum = 0;
        boolean flag = false;
        for (int i = 0; i < rows; i++) {
            int innerCount = 0;
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 1) {
                    innerCount++;
                    flag = true;
                }
            }
            if (flag) {
                level++;
            }
            flag = false;
            if (innerCount > 0 && level == 1) {
                pre = innerCount;
            } else if (innerCount > 0 && level > 1) {
                pre *= innerCount;
                sum += pre;
                pre = innerCount;
            }
        }
        return sum;

    }

    public static void main(String[] args) {
        String[] arr = {"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(arr));

    }
}
