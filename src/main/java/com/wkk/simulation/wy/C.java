package com.wkk.simulation.wy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class C {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int n = line.length;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(line[i]);
        }
        cal(arr, n);
    }

    public static void cal(int[] arr, int n) {
        Arrays.sort(arr);
        int count = 1;
        int curCount = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i] == arr[i - 1]) {
                count += curCount;
            } else {
                curCount++;
                count += curCount;
            }
        }
        System.out.println(count);

    }

    private static void swap(int[] arr, int left, int right) {
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
    }
}
