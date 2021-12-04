package com.wkk.simulation.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 社团主席选举 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 投票人
        int m = sc.nextInt(); // 候选人
        int[] base = new int[n];
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            base[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }
        System.out.println(cal(base, value));
    }

    private static int cal(int[] base, int[] value) {
        // 通过base 计算出最大的结果
        // 通过value 计算出糖果的最小花费 需要排序value
        int n = base.length;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            if (base[i] != 1) {
                queue.offer(value[i]);
            }
        }
        // 统计 当前的最值 1号的最值
        int max = 1;
        int val = 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : base) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) > val) {
                val = map.get(num);
                max = num;
            }
        }
        if (max == 1) {
            return 0;
        }
        int diff = val - map.getOrDefault(1, 0);
        int cout = 0;
        while (cout < diff && !queue.isEmpty()) {
            cout += queue.poll();
        }
        return cout + queue.poll();


    }
}
