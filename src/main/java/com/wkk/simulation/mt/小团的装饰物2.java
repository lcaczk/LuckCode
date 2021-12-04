package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class 小团的装饰物2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int group = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int ans = cal(arr, n, group, k);
        System.out.println(ans);
    }

    private static int cal(int[] arr, int n, int group, int k) {
        // 滑动窗口
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < n) {
            if (arr[i] < k) {
                i = i + 1;
                j = i;
            } else {
                if (i - j + 1 == group) {
                    j += 1;
                    count++;
                }
                i++;
            }
        }
        return count;
    }
}
