package com.wkk.simulation.baidu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/28
 */
public class 小度买果汁 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, Integer> map = new HashMap<>(16);
        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            map.put(cur, map.getOrDefault(cur, 0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int curSum = entry.getValue() / 2;
            int rst = entry.getValue() % 2;
            count += curSum + rst;
        }
        System.out.println(count);

    }

    public static void args(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] love = new int[n];
        int[] num = new int[k+1];
        for (int i = 0; i < n; i++) {
            love[i] = sc.nextInt();
            num[love[i]]++;
        }

        int ans = 0;
        for (int i = 0; i < num.length; i++) {
            if ((num[i] & 1) == 0) { //偶数
                int t = num[i] >> 1;
                ans += t;
            } else {
                ans++;
                num[i]--;
                int t = num[i] >> 1;
                ans += t;
            }
        }
        System.out.println(ans);
    }
}
