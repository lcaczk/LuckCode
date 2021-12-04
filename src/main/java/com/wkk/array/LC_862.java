package com.wkk.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/9/22
 */
public class LC_862 {
    public int shortestSubarray(int[] A, int K) {
        long[] arr = new long[A.length + 1];
        for (int i = 0; i < A.length; i++) {
            arr[i + 1] = arr[i] + A[i];
            if (A[i] >= K) {
                return 1;
            }
        }
        int res = Integer.MAX_VALUE;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
            while (!queue.isEmpty() && arr[i] <= arr[queue.getLast()]) {
                queue.removeLast();
            }
            while (!queue.isEmpty() && arr[i] - arr[queue.peek()] >= K) {
                res = Math.min(res, i - queue.poll());
            }
            queue.add(i);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(4);
        stack.push(3);
        stack.push(2);
        stack.push(1);
        System.out.println(stack);
    }
}
