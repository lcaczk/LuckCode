package com.wkk.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 134 加油站
 * 思路https://leetcode-cn.com/problems/gas-station/solution/shi-yong-tu-de-si-xiang-fen-xi-gai-wen-ti-by-cyayc/
 * @author weikunkun
 * @since 2021/3/25
 */
public class LC_134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        int spare = 0;
        int minSpare = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < len; i++) {
            spare += gas[i] - cost[i];
            if (spare < minSpare) {
                minSpare = spare;
                minIndex = i;
            }
        }

        return spare < 0 ? -1 : (minIndex + 1) % len;
    }

    public static void main(String[] args) {
        int a = 100;
        double b = 100.0;
        Map<Character, Character> map = new HashMap<>();
        String s = "12";
        Character c = s.charAt(1);
        c.equals(map.getOrDefault('1', null));
        Character ch = '1';
        System.out.println(!ch.equals('3'));
    }
}
