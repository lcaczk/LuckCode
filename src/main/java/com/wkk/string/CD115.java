package com.wkk.string;

import java.util.Scanner;

/**
 * 字符串的调整I
 * https://www.nowcoder.com/practice/c53c017b757d4c02b6666b40bfa49a27?tpId=101&&tqId=33183&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * @author weikunkun
 * @since 2021/6/19
 */
public class CD115 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(cal(str));
    }

    private static String cal(String str) {
        // 类似移动0
        int n = str.length();
        int j = n - 1;
        char[] chs = str.toCharArray();
        for (int i = n - 1; i >= 0; i--) {
            if (chs[i] != '*') {
                chs[j--] = chs[i];
            }
        }

        while (j >= 0) {
            chs[j--] = '*';
        }
        return new String(chs);

    }
}
