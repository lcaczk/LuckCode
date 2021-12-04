package com.wkk.simulation.acwing;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/9/25
 */
public class AC_3988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        cal(arr, n, k);
    }

    private static void cal(int[] arr, int n, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (set.contains(arr[i])) {
                continue;
            }
            set.add(arr[i]);
            res.add(i);
        }
        if (res.size() < k) {
            System.out.println("NO");
            return;
        }
        int[] array = res.stream().mapToInt(i -> i).toArray();
        System.out.println("YES");
        for (int i = 0; i < k; i++) {
            System.out.print(array[i] + " ");
        }
    }
}
