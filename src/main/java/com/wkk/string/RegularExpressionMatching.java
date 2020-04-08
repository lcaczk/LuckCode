package com.wkk.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Time: 20-4-8上午8:59
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p){
        Pattern compile = Pattern.compile(p);
        Matcher matcher = compile.matcher(s);
        boolean match = matcher.matches();
        if(match){
            return true;
        }
        else {
            return false;
        }
    }
}
