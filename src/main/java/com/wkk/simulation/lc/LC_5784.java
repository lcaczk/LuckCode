package com.wkk.simulation.lc;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_5784 {
    public boolean makeEqual(String[] words) {
        int n = words.length;
        Map<Character, Integer> map = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }
        for (Integer value : map.values()) {
            if (value % n != 0) {
                return false;
            }
        }
        return  true;
    }
}
