package com.wkk.everyday.sep;

/**
 * @author kongwiki@163.com
 * @since 2020/9/2 7:37 下午
 */
public class Offer20 {
    /**
     * 1. . : .之前不能出现.和e
     * 2. e : e之前不能出现e, 且前一位必须是数字,且后面必须还要有数字
     * 3. +/-: +/-只能出现在0位置或者e后面
     */
    public static boolean isNumber(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        boolean res = true;
        boolean isNums = false;
        boolean isDot = false;
        boolean isE = false;
        String trim = s.trim();
        for (int i = 0; i < trim.length(); i++) {
            if (trim.charAt(i) <= '9' && trim.charAt(i) >= '0') {
                isNums = true;
            } else if (trim.charAt(i) == 'e' || trim.charAt(i) == 'E') {
                if (!isNums || isE) {
                    return false;
                }
                isE = true;
                // 防止出现12e的情况(不能表示数字)
                isNums = false;
            } else if (trim.charAt(i) == '.') {
                if (isE || isDot) {
                    return false;
                }
                isDot = true;
            } else if (trim.charAt(i) == '+' || trim.charAt(i) == '-') {
                if (i != 0 && trim.charAt(i - 1) != 'E' && trim.charAt(i - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }

        }
        return isNums;
    }
}
