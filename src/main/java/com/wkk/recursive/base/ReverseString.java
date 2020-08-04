package com.wkk.recursive.base;

/**
 * @Time: 2020/6/6下午5:24
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseString {
    public static void printReverse(char[] str){
        helper(0, str);
    }

    private static void helper(int start, char[] str) {
        if(str == null || start>=str.length){
            return;
        }
        helper(start+1, str);
        System.out.print(str[start] + " ");

    }

    public static void main(String[] args) {
        char[] a = {'a', 'b', 'c'};
        printReverse(a);
    }
}
