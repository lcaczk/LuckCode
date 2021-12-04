package com.wkk.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/8/18
 */
public class Offer_33 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 思路： 聚集一起
        // 使用 hash映射 key : 排序后的字符串  value : 原字符串
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String base = new String(arr);
            map.computeIfAbsent(base, list -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
