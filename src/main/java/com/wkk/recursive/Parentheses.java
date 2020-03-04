package com.wkk.recursive;

/**
 * @Time: 20-3-3上午9:13
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Parentheses {
    public static void generate(int level, int max, String s){
        if(level == max){
            System.out.println(s);
            return;
        }

        generate(level+1, max, s+"(");
        generate(level+1, max, s+")");
    }

    public static void main(String[] args) {
        generate(0, 2, "");
    }
}
