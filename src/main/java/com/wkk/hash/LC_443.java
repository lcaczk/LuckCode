package com.wkk.hash;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class LC_443 {
    public static int compress(char[] chars) {
        Map<Character, Integer> map = new LinkedHashMap<>(16);
        for (char ch : chars) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                list.add(entry.getKey());
            } else {
                list.add(entry.getKey());
                char c = (char) entry.getValue().intValue();
                list.add(c);
            }
        }
        for (int i = 0; i < list.size(); i++) {
            chars[i] = list.get(i);
        }
        return chars.length;
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        compress(arr);
    }
}
