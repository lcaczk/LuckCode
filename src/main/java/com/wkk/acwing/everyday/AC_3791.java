package com.wkk.acwing.everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/3
 */
public class AC_3791 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        cal(chs, n);
    }

    private static void cal(char[] chs, int n) {
        // 奇数
        // 从左到右
        // 偶数
        // 从右到左
        boolean flag = n % 2 == 0;
        Deque<Character> deque = new ArrayDeque<>();
        Queue<Character> queue = new ArrayDeque<>();
        for (char ch : chs) {
            queue.offer(ch);
        }
        int count = 0;
        if (flag) {
            while (!queue.isEmpty()) {
                if (count % 2 == 0) {
                    deque.addLast(queue.poll());
                } else {
                    deque.addFirst(queue.poll());
                }
                count++;
            }
        } else {
            while (!queue.isEmpty()) {
                if (count % 2 == 0) {
                    deque.addFirst(queue.poll());
                } else {
                    deque.addLast(queue.poll());
                }
                count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        System.out.println(sb.toString());
    }
}
