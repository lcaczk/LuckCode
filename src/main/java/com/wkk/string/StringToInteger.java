package com.wkk.string;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Time: 20-4-8上午8:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class StringToInteger {
    public static int myAtoi(String str) {
        String regex = "([-+]?\\d+)([\\s+-.\\da-zA-Z]*)";
        Pattern compile = Pattern.compile(regex);
        Matcher matcher = compile.matcher(str.trim());
        boolean match = matcher.matches();
        if(match) {
            String value = matcher.group(1);
            boolean isNegative = false;
            if(str.startsWith("-")) {
                isNegative = true;
            }

            try {
                int intValue = Integer.parseInt(value);
                return intValue;
            } catch (Exception e) {
                if(isNegative) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }

            }
        } else {
            return 0;
        }

    }

    public static void main(String[] args) {
        String b  = "fasdfasf423";
        System.out.println(myAtoi(b));
    }
}
