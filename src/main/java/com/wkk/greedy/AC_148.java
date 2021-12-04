package com.wkk.greedy;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class AC_148 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            queue.offer(sc.nextInt());
        }
        int first;
        int second;
        int tmp;
        int sum = 0;
        while (queue.size() >= 2) {
            first = queue.poll();
            second = queue.poll();
            tmp = first + second;
            queue.offer(tmp);
            sum += tmp;
        }
        System.out.println(sum);

    }
}
