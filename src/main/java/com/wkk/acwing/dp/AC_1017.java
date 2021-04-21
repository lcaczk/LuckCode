package com.wkk.acwing.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/20
 */
public class AC_1017 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            int len = sc.nextInt();
            int[] array = new int[len];
            for (int i = 0; i < len; i++) {
                array[i] = sc.nextInt();
            }
            int res = Integer.MIN_VALUE;
            int[] dpLeft = new int[len];
            int[] dpRight = new int[len];
            Arrays.fill(dpLeft, 1);
            Arrays.fill(dpRight, 1);
            for (int i = 1; i < len; i++) {
                // 从前往后求LTS
                for (int j = 0; j < i; j++) {
                    if (array[i] > array[j]) {
                        dpLeft[i] = Math.max(dpLeft[i], dpLeft[j] + 1);
                    }
                }
                res = Math.max(dpLeft[i], res);
            }

            for (int i = len - 2; i >= 0; i--) {
                //从后往前求LTS
                for (int j = i + 1; j > i; j--) {
                    if (array[i] > array[j]) {
                        dpRight[i] = Math.max(dpRight[i], dpRight[j] + 1);
                    }
                }
                res = Math.max(dpRight[i], res);
            }
            System.out.println(res);
        }
    }
}
