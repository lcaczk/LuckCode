package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/10
 */
public class 回文序列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = sc.nextInt();
        }
        cal(arr);
    }

    private static void cal(int[] arr) {
        int ans = 0;
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] == arr[right]) {
                left++;
                right--;
            } else if (arr[left] < arr[right]) {
                int tmp = arr[left] + arr[left + 1];
                arr[left + 1] = tmp;
                left++;
                ans++;
            } else {
                int tmp = arr[right] + arr[right - 1];
                arr[right - 1] = tmp;
                right--;
                ans++;
            }
        }
        System.out.println(ans);
    }
}
