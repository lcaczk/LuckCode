package com.wkk.hash;

import java.util.HashSet;

/**
 * @Time: 20-2-24上午9:30
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counters[s.charAt(i) - 'a']++;
            counters[t.charAt(i) - 'a']--;
        }
        for (int counter : counters) {
            if(counter != 0){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(ValidAnagram.isAnagram(s, t));
    }
}
