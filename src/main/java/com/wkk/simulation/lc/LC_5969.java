package com.wkk.simulation.lc;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2022/1/2
 */
public class LC_5969 {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int asteroid : asteroids) {
            queue.offer(asteroid);
        }

        long res = mass;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (res < cur) {
                return false;
            }
            res += cur;
        }
        return true;

    }
}
