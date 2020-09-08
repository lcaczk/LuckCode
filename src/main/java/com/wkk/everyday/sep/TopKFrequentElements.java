package com.wkk.everyday.sep;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 题目： 前k个高频元素
 * <p>
 *     描述：给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 *     示例：
 *     输入：nums = [1,1,1,2,2,3]
 *     输出：[1,2]
 * <p>
 *     思路：根据词频的map构建一个优先队列
 * @author kongwiki@163.com
 * @since 2020/9/7 11:35 上午
 */
public class TopKFrequentElements {
    // 优先队列 + HashMap
    public static int[] topKFrequent(int[] nums, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0 || k <= 0) {
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        // 构造统计词频的hashmap
        for (Integer num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 根据词频构建优先队列
        Queue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> (map.get(y) - map.get(x)));
        int count = 0;
        for (Integer key : map.keySet()) {
            priorityQueue.offer(key);
//            count++;
//            if (count > k) {
//                priorityQueue.poll();
//            }
        }
//        count = 0;
        while (count < k) {
            res[count++] = priorityQueue.poll();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {1,1,1,2,2,3};
        int[] ints = topKFrequent(a, 2);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
