package com.wkk.everyday.oct;

/**
 * 344. 反转字符串
 * 链接: https://leetcode-cn.com/problems/reverse-string/
 * <p>
 * 简介:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
 * <p>
 * 思路: 三元交换+双指针
 * @author kongwiki@163.com
 * @since 2020/10/8
 */
public class ReverseString {
    public static void reverseString(char[] s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s) {
            sb.append(c);
        }
        s = sb.reverse().toString().toCharArray();
        System.out.println(s);
    }

    public static void reverseStringI(char[] s) {
        int len = s.length-1;
        for (int i = 0; i < s.length/2; i++) {
            char tmp = s[i];
            s[i] = s[len - i];
            s[len - i] = tmp;
        }
    }

    // 双指针
    public static void reverseStringII(char[] s) {
        int len = s.length;
        for(int i = 0 , j = len - 1; i < j ; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    public static void main(String[] args) {
        char[] s = {'a', 'b', 'c', 'd'};
        reverseString(s);
    }
}
