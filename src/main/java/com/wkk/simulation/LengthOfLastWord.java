package com.wkk.simulation;

/**
 * @author weikunkun
 * @since 2021/4/24
 */
public class LengthOfLastWord {
    public static int lengthOfLastWord(String s) {
        if (s.equals(" ")) {
            return 0;
        }
        // 双指针 思路
        int left = 0;
        int right = 0;
        while (right < s.length()) {
            if (s.charAt(right) != ' ') {
                right++;
            } else {
                right += 1;
                left = right;
            }
        }
        return right - left;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("a"));
    }
}
