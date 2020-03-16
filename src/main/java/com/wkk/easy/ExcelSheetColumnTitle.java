package com.wkk.easy;

import java.util.HashMap;
import java.util.Stack;

/**
 * @Time: 20-3-16下午4:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ExcelSheetColumnTitle {
    public static String convertToTitle(int n) {
        HashMap<Integer, Character> map = new HashMap<>();
        String a = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        for (int i = 1; i < 27; i++) {
            map.put(i, a.charAt(i-1));
        }
        Stack<Integer> stack = new Stack<>();
        while (n > 26){
            int b = n%26;
            if(b == 0){
                b = 26;
                n = n-26;
            }
            stack.push(b);
            n = n/26;

        }
        String s = "";
        s += map.get(n);
        while (!stack.isEmpty()){
            s += map.get(stack.pop());
        }
        return s;

    }

    public static void main(String[] args) {
        int n = 1048;
        String s = convertToTitle(n);
        System.out.println(s);
        System.out.println(n/26);
        System.out.println(n%26);
    }
}
