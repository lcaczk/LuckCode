package com.wkk.simulation;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/13
 */
public class 携程III {
    static int procee(int[] scores, int[] cards) {
        // 每次当前的最大结果
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : cards) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int len = scores.length;
        int idx = 0;
        int ans = scores[0];
        int temp = 0;
        int key = 0;
        while (idx < len -1) {
            // 求最值
            for (Integer integer : map.keySet()) {
                int next = idx + integer;
                if (next < len && scores[next] > temp) {
                    temp = scores[next];
                    key = integer;
                }
            }
            idx += key;
            ans += temp;
            map.put(key, map.get(key) - 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] scores = {1,2,3,4};
        int[] cards = {2,1,2};
        System.out.println(procee(scores, cards));
    }
}
