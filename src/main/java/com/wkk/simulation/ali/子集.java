package com.wkk.simulation.ali;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 子集 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[2][n];
            for (int i = 0; i < n; i++) {
                matrix[0][i] = sc.nextInt();
            }
            for (int i = 0; i < n; i++) {
                matrix[1][i] = sc.nextInt();
            }
            cal(matrix, n);
        }
    }

    private static void cal(int[][] martrix, int n) {
        Arrays.sort(martrix, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
        int[] dp = new int[n];
        int[] arr = genArr(martrix);
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            int j = 0;
            while (j < i) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
        }
        int max = Arrays.stream(dp).max().getAsInt();
        System.out.println(max);
    }

    private static int[] genArr(int[][] matrix) {
        int n = matrix[0].length;
        return Arrays.copyOf(matrix[1], n);
    }
}
