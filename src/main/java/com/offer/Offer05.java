package com.offer;

/**
 * 题目：剑指 Offer 05.替换空格
 * 题目链接：https://leetcode-cn.com/problems/ti-huan-kong-ge-lcof/
 * 标签：字符串
 * <p>
 * 题目描述：
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * <p>
 * 示例 1：
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 * <p>
 * 限制：
 * 0 <= s 的长度 <= 10000
 */
class Offer05 {
    public String replaceSpace(String s) {
        // 直接用StringBuilder遍历
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}