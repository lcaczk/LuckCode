package com.wkk.simulation.mt;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class 合并消费券 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(nums[0]);
        int profix = 0;
        for (int i = 1; i < n; i++) {
            while (!stack.isEmpty() && nums[i] == stack.peek()) {
                nums[i] += 1;
                profix++;
                stack.pop();
            }
            stack.push(nums[i]);
        }
        System.out.println(profix);
    }
}
