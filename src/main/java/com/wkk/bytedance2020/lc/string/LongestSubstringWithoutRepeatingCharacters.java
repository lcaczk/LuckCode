package com.wkk.bytedance2020.lc.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @Time: 2020/7/24下午4:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0){
            return 0;
        }
        int height = 0;
        int maxSize = 0;
        List<Character> list = new ArrayList<>();
        while (height < s.length()){
            while (height < s.length() && !list.contains(s.charAt(height))){
                list.add(s.charAt(height));
                height++;
                maxSize = Math.max(maxSize, list.size());
            }
            while (height < s.length() && list.contains(s.charAt(height))){
                list.remove(0);
            }
        }
        return maxSize;
    }
}
