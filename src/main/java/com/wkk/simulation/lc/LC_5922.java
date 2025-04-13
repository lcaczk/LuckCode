package com.wkk.simulation.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/12/12
 */
public class LC_5922 {
    public int countPoints(String rings) {
        // 思路
        // 暴力模拟
        Map<Integer, Set<Character>> map = new HashMap<>();
        int res = 0;
        char[] arr = rings.toCharArray();
        int n = arr.length / 2;
        for (int i = 0; i < n; i++) {
            char color = arr[2 * i];
            int idx = arr[2 * i + 1] - '0';
            map.computeIfAbsent(idx,set -> new HashSet<>()).add(color);
        }
        for (Map.Entry<Integer, Set<Character>> entry : map.entrySet()) {
            if (entry.getValue().size() == 3) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LC_5922 lc_5922 = new LC_5922();
        System.out.println(lc_5922.countPoints("B0R0G0R9R0B0G0"));
    }
}
