package com.wkk.simulation;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/11
 */
public class 便利店结账时间 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        long[][] matrix = new long[len][2];
        String[] a;
        for (int i = 0; i < len; i++) {
            a = sc.next().split(",");
            matrix[i][0] = Long.parseLong(a[0]);
            matrix[i][1] = Long.parseLong(a[1]);
        }
        cal(matrix);
    }
    // 先来先服务算法
    private static void cal(long[][] matrix) {
        // 0 : 开始时间
        // 1 : 耗时时间
        Queue<long[]> serverQueue = new PriorityQueue<long[]>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                return (int) (o1[0] - o2[0]);
            }
        });
        // 开始时间
        long now = matrix[0][0];
        for (long[] consumer : matrix) {
            serverQueue.offer(consumer);
        }
        long total = 0;
        while (!serverQueue.isEmpty()) {
            // 防止断层
            if (serverQueue.peek()[0] >= now) {
                now = serverQueue.peek()[0];
            }
            long[] info = serverQueue.poll();
            long consume = now - info[0] + info[1];
            total += consume;
            now += info[1];
        }
        System.out.println(total);
    }
}
