package com.wkk.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author weikunkun
 * @since 2021/9/7
 */
public class LCP_30 {
    public int magicTower(int[] nums) {
        int positive = Arrays.stream(nums).filter(i -> i > 0).sum();
        int negative = Arrays.stream(nums).filter(i -> i < 0).sum();
        if (positive < negative) {
            return -1;
        }
        // 思路：
        // 已经保证能访问完所有
        // 使用优先队列
        int n = nums.length;
        int sum = 0;
        int count = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        // [100,100,100,-250,-60,-140,-50,-50,100,150]
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0) {
                queue.offer(nums[i]);
            }
            sum += nums[i];
            if (sum > 0) {
                continue;
            }
            sum -= queue.poll();
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {100, 100, -100};
        LCP_30 lcp_30 = new LCP_30();
        lcp_30.magicTower(nums);
    }
}
