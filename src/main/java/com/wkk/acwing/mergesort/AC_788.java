package com.wkk.acwing.mergesort;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/19
 */
public class AC_788 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println(mergeSort(array, 0, len-1));
    }

    private static long mergeSort(int[] arr, int l, int r) {
        // 递归结束, 只有一个元素, 逆序对为 0
        if (l >= r) return 0;

        int mid = l + r >> 1;
        long res = 0;
        // 情况一和情况二, 并对左右数组进行排序
        res += mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r);

        // 归并排序
        int[] tmp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0;
        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) tmp[k++] = arr[i++];
            else {
                tmp[k++] = arr[j++];
                // 情况三
                res += mid - i + 1;
            }
        }

        // 扫尾
        while (i <= mid) tmp[k++] = arr[i++];
        while (j <= r) tmp[k++] = arr[j++];

        // tmp -> arr
        for (i = l, j = 0; i <= r; i++, j++) {
            arr[i] = tmp[j];
        }
        return res;
    }
}
