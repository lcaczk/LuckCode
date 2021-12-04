package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 等差数列 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(cal(arr));
    }

    private static String cal(int[] arr) {
        selectSort(arr);
        int d = arr[1] - arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                return "Impossible";
            }
        }
        return "Possible";
    }

    private static void insertSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int j =  i - 1;
            int cur = arr[i];
            while (j >= 0 && arr[j] > cur) {
                arr[j+1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = cur;
        }
    }

    private static void selectSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            // 寻找区间最小的元素的下标并交换
            int minIdx = i;
            for (int j = i + 1; j < n; j++) {
                minIdx = arr[j] < arr[minIdx] ? j : minIdx;
            }
            int tmp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = tmp;
        }
    }
}
