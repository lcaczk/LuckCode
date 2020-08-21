package com.wkk.hash;

import java.util.*;

/**
 * 题目: 字母异位词分组
 * <p>思路: 使用HashMap存储, 异位的字符进行排序, 得到相同的结果
 * @author kongwiki@163.com
 * @since 2020/8/21下午5:19
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 按照首字符进行排序
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = String.valueOf(array);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(str);
        }
        return new ArrayList<>(map.values());
    }
}
