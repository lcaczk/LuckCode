package com.wkk.string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/3/25
 */
public class LC_12 {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', ']');
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsValue(ch)) {
                if (!stack.isEmpty() && !ch.equals(map.getOrDefault(stack.peek(), null))) {
                    return false;
                } else if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String a = "()[]{}";
        LC_12 lc_12 = new LC_12();
        lc_12.isValid(a);
    }
}
