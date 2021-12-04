package com.wkk.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/8/16
 */
public class LC_648 {
    public static String replaceWords(List<String> roots, String sentence) {
        Set<String> rootset = new HashSet();
        for (String root : roots) rootset.add(root);

        StringBuilder ans = new StringBuilder();
        String[] split = sentence.split(" ");
        for (String word : split) {
            String prefix = "";
            for (int i = 1; i <= word.length(); ++i) {
                prefix = word.substring(0, i);
                if (rootset.contains(prefix)) break;
            }
            if (ans.length() > 0) ans.append(" ");
            ans.append(prefix);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("cat", "bat", "rat"));
        String sentence = "the cattle was rattled by the battery";
        replaceWords(list, sentence);
    }
}
