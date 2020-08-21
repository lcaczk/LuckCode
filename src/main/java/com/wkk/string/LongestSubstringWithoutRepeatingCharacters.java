package com.wkk.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 20-4-2上午11:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int j = 0;
        int len = s.length();
        int max  = 0;
        List<Character> list = new ArrayList<>();
        while (j < len){
            if(!list.contains(s.charAt(j))){
                list.add(s.charAt(j));
                j++;
                if(list.size() > max){
                    max = list.size();
                }
            }else {
                list.remove(0);
            }
        }
        return max;
    }
}
