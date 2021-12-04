package com.wkk.string;

import java.util.Scanner;

/**
 * 翻转字符串（1）
 * https://www.nowcoder.com/practice/972117dd8f334076a5df6a68b0a8f3dd?tpId=101&&tqId=33184&rp=1&ru=/ta/programmer-code-interview-guide&qru=/ta/programmer-code-interview-guide/question-ranking
 * @author weikunkun
 * @since 2021/6/20
 */
public class CD_116 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        char[] chs = str.toCharArray();
        int i = 0;
        int j = 0;
        while (j < chs.length) {
            if (chs[j] != ' ') {
                j++;
            } else {
                swap(chs, i, j - 1);
                j++;
                i = j;
            }
        }
        swap(chs, i, j - 1);
        System.out.println(new String(chs));
    }

    private static void swap(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }
}
