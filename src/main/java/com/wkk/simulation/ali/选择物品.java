package com.wkk.simulation.ali;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/22
 */
public class 选择物品 {
    private static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        cal(n, m);
        System.out.println();
    }
    private static void cal(int n, int m) {
        dfs(n, m, 1, new ArrayDeque<>());
    }

    private static void dfs(int n, int m, int idx, Deque<Integer> stack) {
        if (stack.size() == m) {
            for (int num : stack) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        for (int i = idx; i <= n; i++) {
            stack.addLast(i);
            dfs(n, m, i + 1, stack);
            stack.removeLast();
        }
    }

}
