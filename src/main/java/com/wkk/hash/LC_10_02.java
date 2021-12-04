package com.wkk.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/7/18
 */
public class LC_10_02 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        if (strs == null || strs.length == 0) {
            return ans;
        }
        // 思路
        // map 做映射
        // 变位词 只是位置不同，排序后结果相同 可作为key
        String tmp;
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chs = str.toCharArray();
            Arrays.sort(chs);
            tmp = new String(chs);
            map.computeIfAbsent(tmp, list -> new ArrayList<>()).add(str);
        }
        ans.addAll(map.values());
        return ans;
    }
}
