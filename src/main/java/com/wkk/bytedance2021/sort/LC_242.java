package com.wkk.bytedance2021.sort;

/**
 * 242 有效的字母异位词
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_242 {
    public boolean isAnagram(String s, String t) {
        // 思路
        // map 或 array
        if (t.length() != s.length()) {
            return false;
        }
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < t.length(); i++) {
            int idx = t.charAt(i) - 'a';
            array[idx] -= 1;
            if (array[idx] < 0) {
                return false;
            }
        }
        for (int num : array) {
            if (num > 0) {
                return false;
            }
        }
        return true;
    }
}
