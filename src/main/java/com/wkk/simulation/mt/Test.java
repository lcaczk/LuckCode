package com.wkk.simulation.mt;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/8
 */
public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, k, n);
        }
    }

    private static void cal(int[] arr, int k, int n) {
        Arrays.sort(arr);
        int first = arr[k - 1];
        if (first >= n) {
            System.out.println("NO");
        } else {
            int second = arr[k];
            if (second == first) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                System.out.println(first + 1);
            }
        }
    }
}
