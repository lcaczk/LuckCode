package com.wkk.top.sort;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 快排/堆排
 * @author kongwiki@163.com
 * @since 2020/8/10上午9:36
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> priorty = new PriorityQueue<Integer>((x, y) -> (y - x));
        for (int num : nums) {
            priorty.offer(num);
        }
        while (k > 1) {
            priorty.poll();
            k--;
        }
        return priorty.poll();
    }
}
