package com.wkk.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @Time: 20-4-2上午8:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WordPattern {
    public static boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if(words.length != pattern.length()){
            return false;
        }
        Map index = new HashMap();
        for (Integer i=0; i<words.length; ++i)
            if (index.put(pattern.charAt(i), i) != index.put(words[i], i))
                return false;
        return true;

    }

    public static void main(String[] args) {
        String pattern = "aabb";
        String str = "dog dog cat cat";
        boolean b = wordPattern(pattern, str);
        Map map = new HashMap();


        System.out.println(b);
    }

}
