package com.wkk.simulation.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/27
 */
public class LC_5799 {
    public static long wonderfulSubstrings(String word) {
        // 模拟
        int n = word.length();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (canPermutePalindrome(word.substring(i, j))) {
                    count++;
                }
            }
        }
        return count;
    }

    public static long wonderfulSubstringsIII(String word) {
        HashMap<Integer, Long> cnt = new HashMap<>();
        cnt.put(0,1l);
        long ret = 0l;
        int raw = 0;
        for(int j = 0; j < word.length(); j++){
            int val = 1 << (word.charAt(j) - 'a');
            raw = raw ^ val;
            ret += cnt.getOrDefault(raw, 0l);
            cnt.put(raw, cnt.getOrDefault(raw, 0l) + 1);
            for(int i = 0; i < 10; i++){
                ret += cnt.getOrDefault(raw ^ (1<<i), 0l);
            }
        }
        return ret;
    }

    public static boolean canPermutePalindrome(String s) {
        long highBitmap = 0;
        long lowBitmap = 0;
        for (char ch : s.toCharArray()) {
            if (ch >= 64) {
                highBitmap ^= 1L << ch - 64;
            } else {
                lowBitmap ^= 1L << ch;
            }
        }
        return Long.bitCount(highBitmap) + Long.bitCount(lowBitmap) <= 1;
    }

    private static boolean isNum(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count = 1;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() % 2 != 0) {
                if (count > 1) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        wonderfulSubstringsIII("aabb");
    }
}
