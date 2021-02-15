package com.wkk.top100.stackQueue;

import java.util.*;

/**
 * 20 有效的括号
 * @author weikunkun
 * @since 2021/2/15
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

    public static void main(String[] args) {
        String s = "()[]{}";
        LC_20 lc_20 = new LC_20();
        System.out.println(lc_20.isValid(s));
    }
}
