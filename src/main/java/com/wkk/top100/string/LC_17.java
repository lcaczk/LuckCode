package com.wkk.top100.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 17 电话号码的字母组合
 * 回溯
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_17 {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (Objects.isNull(digits) || "".equals(digits)) {
            return result;
        }
        // 数字和组合的映射
        Map<Character, List<String>> map = new HashMap<>();
        map.put('1', Arrays.asList("!", "@", "#"));
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
        map.put('0', new ArrayList<>());
        StringBuilder sb = new StringBuilder();
        backtrack(result, sb, map, digits, 0);
        return result;
    }

    /**
     * 回溯
     *
     * @param result
     * @param sb
     * @param map
     * @param digits
     */
    private void backtrack(List<String> result, StringBuilder sb, Map<Character, List<String>> map, String digits, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        List<String> stringList = map.get(digits.charAt(index));
        for (int j = 0; j < stringList.size(); j++) {
            sb.append(stringList.get(j));
            backtrack(result, sb, map, digits,index+1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
