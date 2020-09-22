package com.offer;

/**
 * 题目：剑指 Offer 20.表示数值的字符串
 * 题目链接：https://leetcode-cn.com/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof/
 * 标签：数学
 * <p>
 * 题目描述：
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100"、"5e2"、"-123"、"3.1416"、"-1E-16"、"0123"都表示数值，
 * 但"12e"、"1a3.14"、"1.2.3"、"+-5"及"12e+5.4"都不是。
 * <p>
 * 思路：
 * 各种条件判断。。。
 * 有限状态机！
 */
class Offer20 {
    public boolean isNumber(String s) {
        // 去掉开头结尾空格
        s = s.trim();
        if (s.length() == 0) {
            return false;
        }
        char[] charS = s.toCharArray();
        int start = 0;
        // 开头符号
        if (charS[0] == '+' || charS[0] == '-') {
            start = 1;
        }
        // 数字数量
        int numN = 0;
        // e/E 数量
        int numE = 0;
        // 小数点数量
        int numDot = 0;
        for (int i = start; i < s.length(); i++) {
            // 正常数字
            if (charS[i] >= '0' && charS[i] <= '9') {
                numN++;
            }
            // e判断
            else if (charS[i] == 'e' || charS[i] == 'E') {
                // 重复e、e在结尾、没有数字出现e
                if (numE > 0 || i == s.length() - 1 || numN == 0) {
                    return false;
                }
                // e后面符号
                if (charS[i + 1] == '+' || charS[i + 1] == '-') {
                    i++;
                    // e+结尾返回false，如: 4e+
                    if (i == s.length() - 1) {
                        return false;
                    }
                }
                numE++;
            }
            // 小数点判断
            else if (charS[i] == '.') {
                // 重复小数点、e/E后面出现小数点
                if (numDot > 0 || numE > 0) {
                    return false;
                }
                numDot++;
            } else {
                return false;
            }
        }
        return numN != 0;
    }

    public static void main(String[] args) {
        Offer20 solution = new Offer20();
        System.out.println("===true:");
        System.out.println(solution.isNumber("+100"));
        System.out.println(solution.isNumber("5e2"));
        System.out.println(solution.isNumber("-123"));
        System.out.println(solution.isNumber("3.1416"));
        System.out.println(solution.isNumber("-1E-16"));
        System.out.println(solution.isNumber("0123"));
        System.out.println(solution.isNumber("1 "));
        System.out.println(solution.isNumber("1  "));
        System.out.println(solution.isNumber(" 1"));
        System.out.println(solution.isNumber("3."));

        System.out.println("===false:");
        System.out.println(solution.isNumber("12e"));
        System.out.println(solution.isNumber("1a3.14"));
        System.out.println(solution.isNumber("1.2.3"));
        System.out.println(solution.isNumber("+-5"));
        System.out.println(solution.isNumber("12e+5.4"));
        System.out.println(solution.isNumber("e9"));
        System.out.println(solution.isNumber(" "));
        System.out.println(solution.isNumber(". 1"));
        System.out.println(solution.isNumber("1 1"));
        System.out.println(solution.isNumber("4e+"));
    }
}
