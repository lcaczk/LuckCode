package com.wkk.string;

/**
 * @Time: 20-4-2上午9:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        int len = s.length;
        for (int i = 0; i < s.length/2; i++) {
            char tmp = s[i];
            s[i] = s[len - i];
            s[len - i] = tmp;
        }
    }

    public static void main(String[] args) {


    }
}
