package com.wkk.easy;

import java.util.HashMap;

/**
 * @Time: 20-3-16下午5:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ExcelSheetColumnNumber {
    public static int  titleToNumber(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 0; i < a.length(); i++) {
            map.put(a.charAt(i), i+1);
        }
        int sum = 0;
        for (int i = s.length()-1; i >=0; i--) {
            Integer integer = map.get(s.charAt(i));
            sum += Math.pow(26, s.length()-1-i) * integer;
        }
        return sum;
    }

    public int titleToNumberII(String s) {

        int result  = 0;
        for (int i = 0; i < s.length(); i++){
            result *= 26;
            result += ((s.charAt(i) - 'A') + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "ZY";
        int i = titleToNumber(s);
        System.out.println(i);
    }
}
