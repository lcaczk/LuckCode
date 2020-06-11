package com.wkk.everyday;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @Time: 2020/6/11上午9:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class DailyTemperatures {
    public static int[] dailyTemperatures(int[] T) {
        int[] day = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int j = i+1;
            while (j < day.length){
                if(T[j] > T[i]){
                    day[i] = j-i;
                    break;
                }else {
                    j++;
                }
            }
        }
        return day;

    }

    public static int[] dailyTemperaturesII(int[] T){
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[T.length];
        for (int i = 0; i < T.length; i++) {
            int current = T[i];
            while (!stack.isEmpty() && T[stack.peek()] < current){
                Integer preTemperatureIndex = stack.pop();
                ans[preTemperatureIndex] = i - preTemperatureIndex;
            }
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ints = dailyTemperaturesII(temperatures);
        for (int anInt : ints) {
            System.out.print(anInt + " ");
        }
    }
}
