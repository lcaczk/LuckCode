package com.wkk.queue;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/12/3
 */
public class LC_1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 思路
        // 选择最小的元素
        // 负数 -> 正数
        // 正数 -> 多次操作该位置
        Queue<Integer> queue = new PriorityQueue<>();
        for (int num : nums) {
            queue.offer(num);
        }
        while (k > 0) {
            int cur = queue.poll();
            queue.offer(-cur);
            k--;
        }
        return queue.stream().mapToInt(Integer::intValue).sum();
    }

    public static void main(String[] args) {

    }
}
