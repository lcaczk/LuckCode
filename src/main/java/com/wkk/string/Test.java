package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/7/21
 */
public class Test {
    public int lengthOfLastWord(String s) {
        s = s.trim();
        int n = s.length();
        for (int i = n - 1; i >= 0; i--) {
            int j = i;
            while (j >= 0 && Character.isLetter(s.charAt(j))) {
                j--;
            }
            return i - j;
        }
        return 0;
    }
}
