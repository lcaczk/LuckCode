package com.wkk.simulation.lc;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/8/1
 */
public class LC_5831 {
    public static long numberOfWeeks(int[] milestones) {
        int n = milestones.length;
        if (n == 1) {
            return 1;
        }
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        for (int milestone : milestones) {
            queue.offer(milestone);
        }
        long sum = 0;
        while (queue.size() > 1) {
            int fist = queue.poll();
            int second = queue.poll();
            sum += second * 2;
            queue.offer(fist - second);
        }
        int last = queue.poll();
        if (last > 0) {
            sum += 1;
        }
        return sum;
    }

    public static long numberOfWeeksI(int[] milestones) {
        long sum = 0;
        long max = -1;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max, milestone);
        }
        if (max <= (sum + 1) / 2){
            return sum;
        }else {
            return (sum - max) * 2 + 1;
        }
    }

    public static void main(String[] args) {
        int[] arr = {5, 7, 5, 7, 9, 7};
        System.out.println(numberOfWeeksI(arr));
    }
}
