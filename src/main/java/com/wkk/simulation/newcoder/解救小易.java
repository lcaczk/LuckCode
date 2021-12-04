package com.wkk.simulation.newcoder;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/1
 */
public class 解救小易 {
    /**
     * 曼哈顿距离
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] distance = new int[N];
        for (int i = 0; i < N; i++) {
            distance[i] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            distance[i] += sc.nextInt();
        }

        Arrays.sort(distance);
        System.out.println(distance[0] - 2);
    }
}
