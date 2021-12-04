package com.wkk.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/10/31
 */
public class LC_500 {
    public static String[] findWords(String[] words) {
        Map<Character, Integer> map = new HashMap<>();
        String[] arr = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int idx = 0;
        for (String word : arr) {
            char[] chArr = word.toCharArray();
            for (char ch : chArr) {
                map.put(ch, idx);
            }
            idx++;
        }
        Set<String> set = new HashSet<>();
        for (String word : words) {
            char[] chArr = word.toCharArray();
            int pre = 0;
            int n = chArr.length;
            boolean flag = true;
            for (int i = 0; i < n; i++) {
                int cur = map.get(Character.toLowerCase(chArr[i]));
                if (i > 0 && pre != cur) {
                    flag = false;
                    continue;
                }
                pre = cur;
            }
            if (flag) {
                set.add(word);
            }
        }
        return set.stream().toArray(String[]::new);
    }

    public static String[] findWordsII(String[] words) {
        return Arrays.asList(words)
                .stream()
                .filter(s ->
                        s.toLowerCase().replaceAll("^[qwertyuiop]*$", "").equals("")
                                || s.toLowerCase().replaceAll("^[asdfghjkl]*$", "").equals("")
                                || s.toLowerCase().replaceAll("^[zxcvbnm]*$", "").equals("")
                )
                .collect(Collectors.toList())
                .toArray(String[]::new);
    }

    public static void printArr(String[] arr) {
        Arrays.stream(arr).forEach(ele -> System.out.print(ele + " "));
    }

    public static void main(String[] args) {
        String[] words = {"asdfghjkla", "qwertyuiopq", "zxcvbnzzm", "asdfghjkla", "qwertyuiopq", "zxcvbnzzm"};
        String a = "qetueioe";
        boolean res = a.toLowerCase().replaceAll("^[qwertyuiop]*$", "").equals("");
        System.out.println(a);
        printArr(findWordsII(words));

    }
}
