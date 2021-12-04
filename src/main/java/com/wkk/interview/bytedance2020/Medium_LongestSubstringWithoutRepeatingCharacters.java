package com.wkk.interview.bytedance2020;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/7/25上午10:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        int high = 0;
        int len = s.length();
        int max = 0;
        List<Character> res = new ArrayList<>();
        while(high < len){
            if(!res.contains(s.charAt(high))){
                res.add(s.charAt(high));
                high++;
                max = Math.max(max, res.size());
            }else {
                res.remove(0);
            }

        }
        return max;
    }
}
