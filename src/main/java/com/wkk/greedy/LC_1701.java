package com.wkk.greedy;

import java.util.Arrays;

/**
 * 平均等待时间
 *
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_1701 {
    public static double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        // 区间合并问题
        long right = customers[0][0];
        long total = 0;
        Arrays.sort(customers, (x, y) -> (x[0] - y[0]));
        long inSpd = 0;
        for (int[] customer : customers) {
            int innerL = customer[0];
            int spend = customer[1];
            if (innerL >= right) {
                // 可以开始新的任务
                inSpd = spend;
                total += inSpd;
                right = innerL + spend;
            } else {
                right += spend;
                inSpd = right - innerL;
                total += inSpd;
            }
        }
        return total / (double) n;
    }

    public static void main(String[] args) {
        int[][] a = {{5, 2}, {5, 4}, {10, 3}, {20, 1}};
        averageWaitingTime(a);
        int[] array = {1, 2, 3, 5};
        String[] strings = Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
