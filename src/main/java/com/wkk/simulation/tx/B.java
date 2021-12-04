package com.wkk.simulation.tx;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/5
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = sc.nextInt();
        }

        cal(a, b, n);
    }

    private static void cal(int[] a, int[] b, int n) {
        genNum(a, n);
        genNum(b, n);
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        boolean[] visited = new boolean[n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            int cur = b[i];
            idx = find(a, cur, idx, n - 1);
            if (idx == -1) {
                break;
            }
            if (!visited[idx]) {
                count++;
                visited[idx] = true;
            } else {
                while (idx < n && visited[idx]) {
                    idx++;
                }
                if (idx < n) {
                    visited[idx] = true;
                } else {
                    break;
                }
            }

        }
        System.out.println(count);
    }

    private static void genNum(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            arr[i] = genNums(arr[i]);
        }
    }

    private static int find(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1;
        }
        if (left == -1) {
            left = 0;
        }
        int i = left;
        int j = right;
        while (i < j) {
            int mid = i + j >> 1;
            if (arr[mid] <= target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return arr[i] > target ? i : -1;
    }


    private static int genNums(int num) {
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        return count;
    }
}
