package com.wkk.simulation.xp;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/26
 */
public class 字符串命名转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" ");
        char[] chs = str.toCharArray();
        // 1. 第一个单词首字母小写，其余单词首字母大写
        chs[0] = Character.toLowerCase(chs[0]);
        sb.append(new String(chs));
        sb.append(" ");
        sb.append(genCase2(str));
        sb.append(" ");
        sb.append(genCase3(str));
        System.out.println(sb.toString());
    }
    // 2. 单词全部小写，由下划线连接
    private static String genCase2(String str) {
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = str.length();
        while (i < n) {
            if (Character.isUpperCase(chs[i])) {
                for (int k = j; k < i; k++) {
                    sb.append(chs[k]);
                }
                sb.append('_');
                chs[i] = Character.toLowerCase(chs[i]);
                j = i;
            } else {
                i++;
            }
        }
        for (int k = j; k < i; k++) {
            sb.append(chs[k]);
        }
        return sb.deleteCharAt(0).toString();
    }
    // 3. 单词全部小写，由减号连接
    private static String genCase3(String str) {
        char[] chs = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int j = 0;
        int n = str.length();
        while (i < n) {
            if (Character.isUpperCase(chs[i])) {
                for (int k = j; k < i; k++) {
                    sb.append(chs[k]);
                }
                sb.append('-');
                chs[i] = Character.toLowerCase(chs[i]);
                j = i;
            } else {
                i++;
            }
        }
        for (int k = j; k < i; k++) {
            sb.append(chs[k]);
        }
        return sb.deleteCharAt(0).toString();
    }
}
