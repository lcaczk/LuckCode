package com.wkk.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/9/22
 */
public class LC_76 {
    static Map<Character, Integer> eMap = new HashMap<>();
    static Map<Character, Integer> cMap = new HashMap<>();

    public static String minWindow(String s, String t) {
        char[] first = s.toCharArray();
        char[] second = t.toCharArray();
        for (char ch : second) {
            eMap.put(ch, eMap.getOrDefault(ch, 0) + 1);
        }

        int max = Integer.MAX_VALUE;
        int n = first.length;
        int i = 0;
        int j = 0;
        int ansL = -1;
        int ansR = -1;
        while (i < n) {
            cMap.put(first[i], cMap.getOrDefault(first[i], 0) + 1);
            while (check() && j <= i) {
                // 符合条件了，需要将j右移
                int curLen = i - j + 1;
                if (curLen < max) {
                    max = curLen;
                    ansL = j;
                    ansR = i;
                }
                cMap.put(first[j], cMap.get(first[j]) - 1);
                j++;
            }
            i++;
        }
        return ansL == -1 ? "" : s.substring(ansL, ansR + 1);
    }

    private static boolean check() {
        for (Map.Entry<Character, Integer> entry : eMap.entrySet()) {
            if (!cMap.containsKey(entry.getKey())) {
                return false;
            } else if (entry.getValue() > cMap.get(entry.getKey())) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String first = "a";
        String second = "a";
        System.out.println(minWindow(first, second));
    }
}
