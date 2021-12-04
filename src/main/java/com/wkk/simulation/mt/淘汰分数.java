package com.wkk.simulation.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class 淘汰分数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(arr, n, x, y));
    }

    private static int cal(int[] score, int n, int x, int y) {
        // 贪心
        // 对成绩排序
        Arrays.sort(score);
        // 没过线的人数
        int notOk = n - y;
        if (notOk > y){
            return -1;
        } else if (notOk >= x && notOk <= y){
            return score[n-y-1];
        }else{
            return score[x-1];
        }
    }
}
