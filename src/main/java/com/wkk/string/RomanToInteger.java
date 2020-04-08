package com.wkk.string;

import java.util.HashMap;

/**
 * @Time: 20-4-8上午9:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RomanToInteger {
    public static int romanToInt(String s) {
        HashMap<Character, Integer> hashMap = new HashMap<Character, Integer>() {{
            put('I', 1); put('V', 5); put('X', 10); put('L', 50);
                    put('C', 100); put('D', 500); put('M', 1000);
        }};
        int results = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = hashMap.get(s.charAt(i));
            if(i == s.length()-1 || hashMap.get(s.charAt(i+1)) <= hashMap.get(s.charAt(i))){
                results += cur;
            }else {
                results -= cur;
            }
        }
        return results;
    }

    public static void main(String[] args) {
        String a = "III";
        System.out.println(romanToInt(a));
    }
}
