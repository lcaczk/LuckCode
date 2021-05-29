package com.wkk.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/19
 */
public class AC_908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = sc.nextInt();
        int[][] matrix = new int[counts][2];
        for (int i = 0; i < counts; i++) {
            matrix[i][0] = sc.nextInt();
            matrix[i][1] = sc.nextInt();
        }
        int cnt = 0;
        Arrays.sort(matrix, (x, y)->(x[1] - y[1]));
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < counts; i++) {
            if (matrix[i][0] > r) {
                cnt++;
                r = matrix[i][1];
            } else {
                continue;
            }
        }
        System.out.println(cnt);
    }

}
