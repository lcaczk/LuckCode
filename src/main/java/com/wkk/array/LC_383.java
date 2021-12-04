package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/12/4
 */
public class LC_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        char[] base = magazine.toCharArray();
        char[] target = ransomNote.toCharArray();
        for (char ch : base) {
            arr[ch - 'a']++;
        }

        for (char ch : target) {
            if (arr[ch - 'a'] <= 0) {
                return false;
            }
            arr[ch - 'a']--;
        }
        return true;
    }
}
