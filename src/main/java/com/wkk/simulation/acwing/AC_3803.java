package com.wkk.simulation.acwing;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/8/14
 */
public class AC_3803 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, n);
        }
    }

    private static void cal(int[] arr, int n) {
        Deque<Integer> stack = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = n - 1; i >= 0; i--) {
            if (set.contains(arr[i])) {
                continue;
            }
            stack.push(arr[i]);
            set.add(arr[i]);
        }
        printArr(stack);
    }

    private static void printArr(Deque<Integer> stack) {
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
        System.out.println();
    }
}
