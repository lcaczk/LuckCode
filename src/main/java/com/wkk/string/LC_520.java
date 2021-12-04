package com.wkk.string;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/11/13
 */
public class LC_520 {
    public boolean detectCapitalUse(String word) {
        boolean allUpperCase = true;
        boolean allLowerCaseFromSecond = true;

        for (int i = 0; i < word.length(); i++) {
            if (!Character.isUpperCase(word.charAt(i))) {
                allUpperCase = false;
            }
            if (i > 0 && !Character.isLowerCase(word.charAt(i))) {
                allLowerCaseFromSecond = false;
            }
        }
        return allUpperCase || allLowerCaseFromSecond;
    }

    public static void main(String[] args) {
        String[] arr = {"a", "aa", "b", "bb"};
        Arrays.sort(arr);
        Arrays.stream(arr).forEach(i-> System.out.printf(i + " "));
    }
}
