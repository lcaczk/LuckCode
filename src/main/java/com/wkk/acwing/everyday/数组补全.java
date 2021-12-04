package com.wkk.acwing.everyday;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/7/21
 */
public class 数组补全 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, n);
        }
    }

    private static void cal(int[] arr, int n) {
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        // 排序之后 求缺失的值
        // 然后依次 放入到原数组
        Set<Integer> already = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.toSet());
        Set<Integer> standard = new HashSet<>();
        for (int i = 0; i <= n; i++) {
            standard.add(i);
        }
        standard.removeAll(already);
        List<Integer> collect = standard.stream().collect(Collectors.toList());
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr[i] = collect.get(idx++);
            }
        }
        printArr(arr);
    }

    private static void printArr(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
