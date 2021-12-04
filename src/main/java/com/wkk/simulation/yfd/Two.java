package com.wkk.simulation.yfd;

/**
 * 拓扑排序
 * @author weikunkun
 * @since 2021/6/21
 */

import java.util.*;

public class Two {
    static ArrayList<List<Integer>> next;
    static long ans = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        long[] money = new long[n];
        int[] degree = new int[n];

        next = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            next.add(new LinkedList<>());
        }
        for (int i = 0; i < n; i++) {
            money[i] = scanner.nextInt();
            int y = scanner.nextInt();
            ans = Math.max(ans, money[i]);
            if (y != 0) {
                next.get(i).add(y - 2);
                degree[y - 2] += 1;
            }
        }
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                queue.add(i);
            }
        }
        while (!queue.isEmpty()) {
            Integer index = queue.pollFirst();
            for (Integer integer : next.get(index)) {
                if (money[index] > 0) {
                    money[integer] += money[index];
                }
                degree[integer]--;
                if (degree[integer] == 0) {
                    ans = Math.max(ans, money[integer]);
                    queue.add(integer);
                }
            }
        }
        System.out.println(ans % 1000000003);
    }
}

