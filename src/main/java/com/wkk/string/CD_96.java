package com.wkk.string;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 判断两个字符串是否互为旋转词
 * https://www.nowcoder.com/practice/687deda2cc57473499e058207f6258cf?tpId=101&&tqId=33164&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * 基础的字符串匹配问题 双指针
 * 如果为子串   则需要在不等于时 置零
 * 如果为子序列 不需要 置零
 * @author weikunkun
 * @since 2021/6/19
 */
public class CD_96 {
    public static boolean isRoate(String str1, String str2) {
        if (str1 == null || str2 == null
                || str1.length() != str2.length()) {
            return false;
        }
        String ss =  str2 + str2;
        int n = ss.length();
        int i = 0;
        int j = 0;
        while (i < n && j < str1.length()) {
            if (ss.charAt(i) == str1.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
            i++;
        }
        return j == str1.length();
//         if (ss.contains(str1)) {
//             return true;
//         }
//         return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String nAndm = in.readLine();
        String str1 = in.readLine();
        String str2 = in.readLine();
        if (isRoate(str1, str2)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
