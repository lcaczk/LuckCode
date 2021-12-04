package com.wkk.simulation.wy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String[] fist = sc.nextLine().split(" ");
        int target = Integer.parseInt(sc.nextLine());
        int n = fist.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(fist[i]);
        }
        cal(arr, n, target);
    }

    private static void cal(int[] arr, int n, int target) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            int j = i + 1;
            while (j < n) {
                if (arr[i]  + arr[j] <= target) {
                    count++;
                }
                j++;
            }
        }
        System.out.println(count);
    }
}
