package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/29
 */
public class 搭配出售 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Long> list = new ArrayList<>();
        while (sc.hasNextLong()) {
            list.add(sc.nextLong());
        }
        System.out.println(cal(list));
    }

    private static long cal(List<Long> list) {
        // 贪心
        // 堆 按照组合结果 构成大根堆 信息为 领 0  裤 1 帽 2
        int n = list.size();
        long[] nums = list.subList(0, 4).stream().mapToLong(i -> i).toArray();
        long[] group = list.subList(4, n).stream().mapToLong(i -> i).toArray();
        Map<Integer, Long> freMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            freMap.put(i, nums[i]);
        }
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < group.length; i++) {
            map.put(i, group[i]);
        }
        //  价值相同 无所谓
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (int) (map.get(y) - map.get(x)));
        for (Integer key : map.keySet()) {
            queue.offer(key);
        }
        // 衬衫作为基础值
        long sum = 0;
        long baseNums = nums[nums.length - 1];
        while (baseNums > 0 && !queue.isEmpty()) {
            int idx = queue.poll();
            long count = freMap.get(idx);
            if (baseNums > count) {
                sum += count * map.get(idx);
                baseNums -= count;
            } else {
                sum += baseNums * map.get(idx);
                baseNums = 0;
            }
        }
        return sum;
    }
}
