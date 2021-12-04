package com.wkk.simulation.acwing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/3
 */
public class AC_3733 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>(16);
        int cur;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            cur = sc.nextInt();
            sum += cur;
            if (cur % 2 == 0) {
                map.put(0, map.getOrDefault(0, 0) + 1);
            } else {
                map.put(1, map.getOrDefault(1, 0) + 1);
            }
        }
        if (sum % 2 == 1) {
            System.out.println(map.getOrDefault(1, 0));
        } else {
            System.out.println(map.getOrDefault(0, 0));
        }
    }
}
