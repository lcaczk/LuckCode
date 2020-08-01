package com.wkk.string;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kongwiki@163.com
 * @since 2020/8/1下午12:45
 */
public class IsomorphicStrings {
    public static  boolean isIsomorphic(String s, String t){
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t, s);
    }

    private static boolean isIsomorphicHelper(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i<s.length(); i++){
            Character c1 = s.charAt(i);
            Character c2 = t.charAt(i);
            if(map.containsKey(c1)){
                if(!map.get(c1).equals(c2)){
                    return false;
                }
            }else {
                map.put(c1, c2);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "ab";
        String b = "aa";
        boolean isomorphic = isIsomorphic(a, b);
        System.out.println(isomorphic);
    }
}
