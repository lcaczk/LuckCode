package com.wkk.stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/8/19
 */
public class LC_735 {
    /**
     *
     * @param asteroids
     * @return
     */
    public static int[] asteroidCollision(int[] asteroids) {
        // 寻找 最近的绝对值大于该元素的元素
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        boolean flag = true;
        for (int num : asteroids) {
            while (num < 0 && !stack.isEmpty() && stack.peek() <= Math.abs(num)) {
                if (stack.peek() == Math.abs(num)) {
                    flag = false;
                    stack.pop();
                    break;
                } else {
                    stack.pop();
                }
            }
            if (num > 0) {
                stack.push(num);
            }
            if (stack.isEmpty() && flag) {
                list.add(num);
            }
            flag = true;
        }
        int idx = list.size();
        while (!stack.isEmpty()) {
            list.add(idx, stack.pop());
        }
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {-2, 1, 1, -1};
        int[] ints = asteroidCollision(arr);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }
}
