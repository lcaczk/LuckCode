package com.wkk.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 17 电话号码的字母组合
 * @author weikunkun
 * @since 2021/2/16
 */
public class LetterCombinationsOfAPhoneNumber {
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
        backtrack(result, sb, map, digits, 0, 0);
        return result;
    }

    /**
     *
     * @param result
     * @param sb
     * @param map
     * @param digits
     * @param start 用于管理每一层中的集合内的起始位置
     * @param index 用于管理第几层应该是那个集合
     */
    private void backtrack(List<String> result, StringBuilder sb, Map<Character, List<String>> map, String digits, int start, int index) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        // 当前的集合
        List<String> stringList = map.get(digits.charAt(index));
        for (int i = 0; i < stringList.size(); i++) {
            sb.append(stringList.get(i));
            backtrack(result, sb, map, digits, i+1, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
