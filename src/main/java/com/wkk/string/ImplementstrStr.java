package com.wkk.string;

/**
 * @Time: 20-4-2上午9:45
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle) {
        if(needle == null){
            return 0;
        }
        for (int i = 0; i < haystack.length()-needle.length(); i++) {
            if(haystack.substring(i, i+needle.length()).equals(needle)){
                return i;
            }
        }
        return -1;
    }

}
