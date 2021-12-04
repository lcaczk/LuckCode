package com.wkk.simulation.xp;

import java.util.HashMap;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class 罗马数字转整数 {
    public int romanToInt (String s) {
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
}
