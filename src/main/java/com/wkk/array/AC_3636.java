package com.wkk.array;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class AC_3636 {
    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        // 思路
        // 能被整除的继续整除不能被整除的跳过
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            cal(arr, x, n);
        }
    }

    private static void cal(int[] arr, int x, int n) {
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (num % x != 0) {
                break;
            }
            int count = x;
            while (num % x == 0) {
                int k = num / x;
                map.put(k, count);
                num = k;
                count *= 2;
            }
        }
        int sum = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            sum += entry.getKey() * entry.getValue();
        }
        System.out.println(sum);
    }

}
