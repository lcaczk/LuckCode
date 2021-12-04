package com.wkk.sort.quick;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/7/19
 */
public class Offer45 {
    public static String minNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
            return "";
        }
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
        int n = arr.length;
        quickSort(arr, 0, n - 1);
        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str);
        }
        return sb.toString();
    }

    private static void quickSort(String[] nums, int i, int j) {
        if (i > j) {
            return;
        }
        int pos = partition(nums, i, j);
        quickSort(nums, i, pos - 1);
        quickSort(nums, pos + 1, j);
    }

    private static int partition(String[] arr, int i, int j) {
        String tmp = arr[i];
        while (i < j) {
            while (i < j && (arr[j] + tmp).compareTo(tmp + arr[j]) >= 0) {
                j--;
            }
            arr[i] = arr[j];
            while (i < j && (arr[i] + tmp).compareTo(tmp + arr[i]) <= 0) {
                i++;
            }
            arr[j] = arr[i];
        }
        arr[i] = tmp;
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4};
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);
    }
}
