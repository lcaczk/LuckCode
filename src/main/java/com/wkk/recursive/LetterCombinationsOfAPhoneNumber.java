package com.wkk.recursive;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Time: 20-3-3上午11:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LetterCombinationsOfAPhoneNumber {
    static List<String> result = new ArrayList<String>();
    static Map<Character, String> button = new HashMap<Character, String>(){{
        put('2', "abc"); put('3', "def"); put('4', "ghi"); put('5', "jkl");
        put('6', "mno"); put('7', "pqrs"); put('8', "tuv"); put('9', "wxyz");
    }};
    public static List<String> letterCombinations(String digits) {
        if("".equals(digits)){
            return result;
        }
        dfs(0, "", result, button, digits);
        return result;

    }

    private static void dfs(int start, String cur, List<String> result, Map<Character, String> button, String digits){
        if(cur.length() == digits.length()){
            result.add(cur);
            return;
        }

        for (int i = start; i < digits.length(); i++) {
            for (char c : button.get(digits.charAt(i)).toCharArray()) {
                dfs(i + 1, cur + c, result, button, digits);
            }
        }
    }

    public static void main(String[] args) {
        String a = "23";
        List<String> list = letterCombinations(a);
        System.out.println(list);
    }
}
