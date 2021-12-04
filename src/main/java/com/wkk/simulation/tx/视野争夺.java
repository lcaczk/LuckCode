package com.wkk.simulation.tx;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/2
 */
public class 视野争夺 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nums = sc.nextInt();
        int max = sc.nextInt();
        int[][] matrix = new int[nums][2];
        int l = 0;
        int r = 0;
        for (int i = 0; i < nums; i++) {
            matrix[i][0] = sc.nextInt();
            l = Math.min(l, matrix[i][0]);
            matrix[i][1] = sc.nextInt();
            r = Math.max(r, matrix[i][1]);
        }
        // 按照左边进行排序
        if (l > 0 || r < max) {
            System.out.println(-1);

        } else {
            Arrays.sort(matrix, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
            System.out.println(cal(matrix, nums, max));
        }
    }

    // 区间贪心问题
    private static int cal(int[][] matrix, int n, int max) {
        int count = 0;
        int right = 0;
        int idx = 0;
        while (right < max) {
            int innerMax = right;
            // 在小于当前right的前提下， 能达到最右边
            while (idx < n && matrix[idx][0] <= right) {
                innerMax = Math.max(innerMax, matrix[idx][1]);
                idx++;
            }
            // 达到最大后, 新增一个
            count++;
            right = innerMax;
            if (right >= max) {
                return count;
            }
            if (idx >= n) {
                return -1;
            }
        }
        return count;
    }
}
