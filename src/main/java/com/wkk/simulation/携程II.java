package com.wkk.simulation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/13
 */
public class 携程II {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] matrix = new int[len][3];
        int[][] matrixTemp = new int[3][len];
        int m = -1;
        // 构建数组
        while (++m < 3) {
            for (int i = 0; i < len; i++) {
                matrixTemp[m][i] = sc.nextInt();
            }
        }
        //
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < len; j++) {
                matrix[j][i] = matrixTemp[i][j];
            }
        }
        List<Integer> order = getOrder(matrix);
        int sum = 0;
        for (int i : order) {
            sum += matrix[i][2];
        }
        System.out.println(sum);

    }

    static class Task {
        int id;
        int[] time;

        Task(int id, int[] time) {
            this.id = id;
            this.time = time;
        }
    }

    public static List<Integer> getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] ts = new Task[n];
        // new 出来每一个任务数据结构，方便排序
        for (int i = 0; i < n; ++i) ts[i] = new Task(i, tasks[i]);
        // 按照开始时间递增排好序
        Arrays.sort(ts, Comparator.comparingInt(o -> o.time[0]));
        // 优先级队列，比较器需要 同样开始时间，价格高的在前，不同开始时间，则按照开始时间从小到大
        // 0 开始
        // 1 结束
        // 2 金额
        PriorityQueue<Task> priorityQueue = new PriorityQueue<>((o1, o2) ->
                o1.time[0] == o2.time[0] ? o2.time[2] - o1.time[2] : o1.time[1] - o2.time[1]
        );
        // 直接从第一个任务开始的时间开始累加计时
        long T = ts[0].time[0];
        List<Integer> list = new ArrayList<>();
        // 把所有开始时间 time[0] 不超过 T 的任务加到优先级队列里面
        int iter = 0;   // iter 表示将要添加到优先级队列中第几个了
        for (; iter < n; ++iter) {
            // 把所有不超过当前时间 T 的元素都放到优先级队列里面去
            if (ts[iter].time[0] <= T) priorityQueue.offer(ts[iter]);
                // 如果 iter 指向的任务开始时间已经超过了 T，那么后面的都超过，就跳出来
            else break;
        }

        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            while (!priorityQueue.isEmpty()) {
                priorityQueue.poll();
            }
            // 处理完这个任务，时间上要累加，同时往返回值中记录下标
            T = task.time[1];
            list.add(task.id);
            for (; iter < n; ++iter) {
                // 把所有 = 当前时间 T 的元素都放到优先级队列里面去
                if (ts[iter].time[0] == T) {
                    priorityQueue.offer(ts[iter]);
                }
            }
        }
        return list;
    }
}
