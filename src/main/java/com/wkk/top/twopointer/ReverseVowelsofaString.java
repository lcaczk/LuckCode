package com.wkk.top.twopointer;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Time: 2020/6/26上午11:01
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseVowelsofaString {
    private final static HashSet<Character> vowels = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public static String reverseVowels(String s) {
        if (s == null) {
            return null;
        }
        int i = 0, j = s.length() - 1;
        char[] result = new char[s.length()];
        while (i<=j){
            char ci = s.charAt(i);
            char cj = s.charAt(j);
            if(!vowels.contains(ci)){
                result[i++] = ci;
            }else if(!vowels.contains(cj)){
                result[j--] = cj;
            }else {
                result[i++] = ci;
                result[j--] = cj;
            }
        }
        return new String(result);
    }

    public static void main(String[] args) {
        int[] arr = new int[10];
        arr[0] = 1;
        arr[1] = 2;
        arr = Arrays.copyOf(arr, 100);
        System.out.println(arr.length);
        System.out.println(arr[0]);

    }
}
