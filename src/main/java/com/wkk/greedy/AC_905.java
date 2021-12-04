package com.wkk.greedy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/10
 */
public class AC_905 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = sc.nextInt();
        int[][] matrix = new int[counts][2];
        int idx = 0;
        while (idx < counts) {
            matrix[idx][0] = sc.nextInt();
            matrix[idx][1] = sc.nextInt();
            idx++;
        }
        // 类似于合并区间
        // 合并区间是合并为最右边的结果
        // 这里是合并为最左边的结果
        // 如果新的区间最左边的值 《 已经合并的区间的最右边的值  cnts + 1
        int cnts = 1;
        Arrays.sort(matrix, (x, y)->(x[1] - y[1]));
        for (int i = 1; i < counts; i++) {
            if (matrix[i][0] > matrix[i-1][1]) {
                cnts++;
            } else {
                //选择最小右侧区间以求找到最大的重合次数，而区间合并是选择最大的右侧以求最长的覆盖范围
                matrix[i][1] = Math.min(matrix[i-1][1], matrix[i][1]);
            }
        }
        System.out.println(cnts);
    }
}
