package com.wkk.string;

import java.util.Scanner;

/**
 * 翻转字符串（2）
 * https://www.nowcoder.com/practice/79c562297c0e4ff0952ef39ecde1bd6b?tpId=101&&tqId=33185&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * @author weikunkun
 * @since 2021/6/20
 */
public class CD_117 {
    /**
     * 先翻转 0 : k
     * 再翻转 k + 1 : n
     * 再整体翻转
     * @param args
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        reverse(chs, 0, n - 1);
        reverse(chs, n, str.length() - 1);
        reverse(chs, 0, str.length() - 1);
        System.out.println(new String(chs));
    }

    private static void reverse(char[] chars, int left, int right) {
        char tmp = 0;
        while (left < right) {
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }
    }
}
