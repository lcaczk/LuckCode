package com.wkk.string;

import java.util.HashMap;

/**
 * @Time: 20-4-4下午11:04
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FirstUniqueCharacterInAString {
    public static int firstUniqChar(String s) {
        int index = -1;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if(hashMap.containsKey(s.charAt(i))){
                hashMap.put(s.charAt(i), hashMap.get(s.charAt(i)) + 1);
            }else {
                hashMap.put(s.charAt(i), 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            if(hashMap.get(s.charAt(i)) == 1){
                index =  i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        String s = "loveleetcode";
        firstUniqChar(s);
    }
}
