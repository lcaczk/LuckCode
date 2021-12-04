package com.wkk.simulation.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 回转寿司 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(cal(arr, n));
        }
    }

    private static int cal(int[] arr, int n) {
        // 状态dp
        // 因为是环
        // 使用最大最小值 避免循环整个数组，确定起始位置
        int sum = Arrays.stream(arr).sum();
        int max = arr[0];
        int min = arr[0];
        int dpMax = arr[0];
        int dpMin = arr[0];
        for (int i = 1; i < n; i++) {
            dpMax = Math.max(arr[i], dpMax + arr[i]);
            dpMin = Math.min(arr[i], dpMin + arr[i]);
            max = Math.max(max, dpMax);
            min = Math.min(min, dpMin);
        }
        return max > sum - min ? max : sum - min;
    }
}
