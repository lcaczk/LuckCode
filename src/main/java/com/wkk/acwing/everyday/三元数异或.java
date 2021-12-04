package com.wkk.acwing.everyday;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/13
 */
public class 三元数异或 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int nums = sc.nextInt();
            cal(nums, n);
        }
    }

    public static void cal(int nums, int n) {
        Deque<Integer> fStack = new LinkedList<>();
        Deque<Integer> sStack = new LinkedList<>();
        while (nums != 0) {
            int pop = nums % 10;
            nums /= 10;
            if (pop == 2) {
                fStack.push(1);
                sStack.push(1);
            } else if (pop == 1) {
                fStack.push(1);
                sStack.push(0);
            } else {
                fStack.push(0);
                sStack.push(0);
            }
        }
        StringBuilder first = new StringBuilder();
        StringBuilder second = new StringBuilder();
        while (fStack.isEmpty()) {
            first.append(fStack.pop());
        }
        while (sStack.isEmpty()) {
            second.append(fStack.pop());
        }
        System.out.println(first.toString());
        System.out.println(second.toString());
    }
}
