package com.wkk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/11/8
 */
public class LC_299 {
    public static String getHint(String secret, String guess) {
        // 模拟题
        // 多少位属于数字并且位置都对 A（公牛）
        // 多少位属于数字但是位置不对 B（奶牛）
        char[] first = secret.toCharArray();
        char[] second = guess.toCharArray();
        int numsA = 0;
        int numsB = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (char num : first) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int n = first.length;
        for (int i = 0; i < n; i++) {
            if (first[i] == second[i]) {
                numsA++;
                map.put(first[i], map.get(first[i]) - 1);
            }
        }
        int i = 0;
        while (i < n && first[i] != second[i]) {
            System.out.println(map);
            if (map.containsKey(second[i]) && map.get(second[i]) > 0) {
                numsB++;
                map.put(second[i], map.get(second[i]) - 1);
            }
            i++;
        }

        return numsA + "A" + numsB + "B";

    }

    public static void main(String[] args) {
        System.out.println(getHint("1807", "7810"));
    }
}
