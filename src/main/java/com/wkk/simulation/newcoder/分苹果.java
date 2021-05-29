package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 思路：
 * 平均分
 * 1. 小于平均值 要求能被2整除
 * 2. 大于平均值 要求能被2整除
 * @author weikunkun
 * @since 2021/5/29
 */
public class 分苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int idx = 0;
        int[] array = new int[len];
        while (idx < len) {
            array[idx++] = sc.nextInt();
        }
        //
        System.out.println(cal(array));
    }

    private static int cal(int[] array) {
        int sum = Arrays.stream(array).sum();
        int n = array.length;
        int ave = sum / n;
        if (sum % n != 0) {
            return -1;
        }
        int count = 0;
        int diff = 0;
        for (int num : array) {
            if (num < ave) {
                diff = ave - num;
                if (diff % 2 != 0) {
                    return -1;
                }
                count += diff / 2;
            } else if (num > ave) {
                diff = num - ave;
                if (diff % 2 != 0) {
                    return -1;
                }
            }
        }
        return count;
    }
}
