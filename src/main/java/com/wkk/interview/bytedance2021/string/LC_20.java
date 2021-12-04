package com.wkk.interview.bytedance2021.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/3/17
 */
public class LC_20 {
    public boolean isValid(String s) {
        if (Objects.isNull(s) || "".equals(s)) {
            return true;
        }
        char[] array = {'(', '[', '{', ')', ']', '}'};
        Set<Character> set = new HashSet<>();
        Map<Character, Character> map = new HashMap<>();
        for (char c : array) {
            set.add(c);
        }
        for (int i = 0; i < 3; i++) {
            map.put(array[i], array[3+i]);
        }
        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                stack.push(s.charAt(i));
            }
            if (map.containsValue(s.charAt(i))) {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!Objects.equals(map.getOrDefault(stack.pop(), null), s.charAt(i))) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
