package com.wkk.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/8/3
 */
public class LC_187 {
    public static List<String> findRepeatedDnaSequences(String s) {
        // 思路
        // 长度为10的子串
        // 从 [0, n - 10]
        // 使用set存储已经出现的结果, 保证唯一
        int n = s.length();
        Set<String> set = new HashSet<>();
        Set<String> already = new HashSet<>();
        for (int i = 0; i <= n - 10; i++) {
            String innerStr = s.substring(i, i + 10);
            if (already.contains(innerStr)) {
                set.add(innerStr);
            }
            already.add(innerStr);

        }
        return set.stream().collect(Collectors.toList());
    }

    public static List<String> findRepeatedDnaSequencesII(String s) {
        Map<String, Integer> map = new HashMap<>();
        int n = s.length();
        for (int i = 0; i + 10 <= n; i++) {
            String innerStr = s.substring(i, i + 10);
            map.put(innerStr, map.getOrDefault(innerStr, 0) + 1);
        }
        System.out.println(map);
        List<String> res = map.entrySet().stream().filter(entry -> (entry.getValue() >= 1)).map(Map.Entry::getKey).collect(Collectors.toList());
        return res;

    }

    public static void main(String[] args) {
        String s = "AAAAAAAAAAAAA";
        System.out.println(s.length());
        System.out.println(findRepeatedDnaSequencesII(s));
    }
}
