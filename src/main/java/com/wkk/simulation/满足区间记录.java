package com.wkk.simulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 满足区间记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> queue = new PriorityQueue<>((x, y)->(x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]));
        int n = sc.nextInt();
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int[] arr = new int[3];
            arr[0] = sc.nextInt();
            arr[1] = sc.nextInt();
            arr[2] = sc.nextInt();
            queue.offer(arr);
        }
        List<Integer> res = new ArrayList<>();
        while (!queue.isEmpty() && queue.peek()[1] < target && queue.peek()[2] < target) {
            queue.poll();
        }
        while (!queue.isEmpty() && queue.peek()[1] <= target && queue.peek()[2] >= target) {
            res.add(queue.poll()[0]);
        }
        if (res.isEmpty()) {
            System.out.println("null");
        } else {
            Collections.sort(res);
            for (Integer num : res) {
                System.out.printf(num + " ");
            }
            System.out.println();
        }
    }
}
