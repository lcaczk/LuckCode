package com.wkk.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class lC_253 {
    public static int minMeetingRooms(int[][] intervals) {
        // 贪心策略
        // 按照左端点排序
        // 实时更新右端点
        // 有重叠的数量+1
        // 右端点：Math.max(right, cur[1])
        int right = Integer.MIN_VALUE;
        Arrays.sort(intervals, (x, y) -> (x[0] - y[0]));
        int count = 0;
        // 存放已经使用的会议室的的结束时间， 小根堆
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] interval : intervals) {
            int innerR = interval[1];
            int innerL = interval[0];
            // 更新内部的结束时间
            if (!queue.isEmpty() && queue.peek() <= innerL) {
                queue.poll();
                queue.offer(innerR);
            } else if (queue.isEmpty() || innerL < queue.peek()) {
                queue.offer(innerR);
            }
        }
        return queue.size();
    }

    public static void main(String[] args) {
        int[][] intervals = {{26, 29}, {19, 26}, {19, 28}, {4, 19}, {4, 25}};
        System.out.println(minMeetingRooms(intervals));
        Set<String> set = new HashSet<>();
        String[] strings = set.stream().toArray(String[]::new);
        List<String> list = new ArrayList<>();
        list.stream().toArray(String[]::new);
    }
}
