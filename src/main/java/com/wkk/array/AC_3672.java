package com.wkk.array;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/14
 */
public class AC_3672 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-- > 0) {
            int len = sc.nextInt();
            int[] arr = new int[len];
            for (int i = 0; i < len; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr);
        }
    }

    private static void cal(int[] arr) {
        // j - aj != i - ai
        // ai - aj != i - j
        // 只需要返回一个结果
        // 直接逆序输出 就能保证符合条件
        Arrays.sort(arr);
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        int n = arr.length;
        for(int j = n - 1; j >= 0; j--) {
            System.out.print(arr[j] + " ");
        }
        System.out.println();
    }
}
