package com.wkk.simulation.lc;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/9/5
 */
public class LC_5864 {
    public int numberOfWeakCharacters(int[][] a) {
        Arrays.sort(a, (x, y) -> (x[0] == y[0] ? y[1] - x[1] : x[0] - y[0]));
        int count = 0;
        int right = -1;
        int n = a.length;
        Deque<Integer> stack  = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()][1] < a[i][1]) {
                count++;
                stack.pop();
            }

            stack.push(i);
            // if (a[i][1] < right) {
            //     count++;
            // }
            // right = Math.max(right, a[i][1]);

        }
        return count;
    }

    public static int numberOfWeakCharacters(int[] a) {
        int count = 0;
        int right = -1;
        int n = a.length;
        Deque<Integer> stack  = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && a[stack.peek()] < a[i]) {
                count++;
                stack.pop();
            }

            stack.push(i);
            // if (a[i][1] < right) {
            //     count++;
            // }
            // right = Math.max(right, a[i][1]);

        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {9, 10, 9, 5, 7, 4};
        System.out.println(numberOfWeakCharacters(arr));
    }
}
