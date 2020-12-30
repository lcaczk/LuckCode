package com.wkk.spring.arraystr;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * @author kongwiki@163.com
 * @since 2020/12/30
 */
public class LC03 {
    public static int lengthOfLongestSubstring(String s) {
        // 使用set存储，之后寻找最大不重复元素
        Set<Character> uniqChar = new HashSet<>();
        int temp = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++) {
            if (i > 0 && !uniqChar.contains(s.charAt(i))) {
                uniqChar.add(s.charAt(i));
                temp += 1;
            } else {
                temp = 1;
            }
            max = Math.max(max, temp);
        }
        return max;
    }

    public static void main(String[] args) {
        String a = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(a));
    }
}
