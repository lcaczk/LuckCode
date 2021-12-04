package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/6
 */
public class 数字游戏 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        int num = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] > num + 1) {
                break;
            }
            num += arr[i];
        }
        System.out.println(num + 1);
    }
}
