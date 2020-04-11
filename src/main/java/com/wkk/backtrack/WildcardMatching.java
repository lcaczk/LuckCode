package com.wkk.backtrack;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Time: 20-4-11下午7:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class WildcardMatching {
    public static boolean isMatch(String s, String p) {
        String pattern  = "*";
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(s);
        return matcher.matches();
    }

    public static void main(String[] args) {
        String p = "\\*";
        String s = "aaa";
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(s);
        System.out.println(matcher.matches());


    }
}
