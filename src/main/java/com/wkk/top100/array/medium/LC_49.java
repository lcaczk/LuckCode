package com.wkk.top100.array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 49 字母异位词分组
 * @author weikunkun
 * @since 2021/2/18
 */
public class LC_49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 1. map 存储 不同的组合
        // 2. 依次遍历，将不同的组合的异位次放一起
        // 时间复杂度 O(n klogk) n : 数组长度 m: 最大的单词长度
        // 空间复杂度 O(nm): 不同的组合
        List<List<String>> result = new ArrayList<>();
        List<String> values = new ArrayList<>();
        Set<String> set = new HashSet<>();
        if (null == strs || strs.length == 0) {
            return result;
        }
        Map<String, List<String>> map = new HashMap<>(16);
        for (String str : strs) {
            char[] array = str.toCharArray();
            List<String> currKeyList = map.getOrDefault(sortCharArray2String(array), new ArrayList<>());
            currKeyList.add(str);
            map.put(sortCharArray2String(array), currKeyList);
        }
        map.values().forEach(temp-> {
            result.add(temp);
        });
        return result;

    }

    private String sortCharArray2String(char[] array) {
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        for(char ch : array) {
            sb.append(ch);
        }
        return sb.toString();
    }
}
