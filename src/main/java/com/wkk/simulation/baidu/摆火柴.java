package com.wkk.simulation.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class 摆火柴 {
    private static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int nums = sc.nextInt();
//        int n = sc.nextInt();
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int[] counts = {2, 5, 5, 4, 5, 6, 3, 7, 6};
        for (int i = 0; i < numbers.length; i++) {
            map.put(numbers[i], counts[i]);
        }
        int[] arr = {3, 7, 8, 4};
        int n = 20;
        System.out.println(cal(arr, n));
    }

    private static int cal(int[] arr, int n) {
        // 等量 数字大的在前
        // 不等量 量小的在前
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (map.get(x) == map.get(y) ? y - x : map.get(x) - map.get(y)));
        for (int i : arr) {
            queue.offer(i);
        }
        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty() || n > 0) {
            int value = queue.poll();
            int num = map.get(value);
            while (n > 0) {
                sb.append(num);
                n -= num;
            }
        }
        return 0;
    }
}
