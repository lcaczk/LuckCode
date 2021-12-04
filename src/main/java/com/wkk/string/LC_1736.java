package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/7/24
 */
public class LC_1736 {
    public static String maximumTime(String time) {
        char[] chs = time.toCharArray();
        int n = chs.length;
        for (int i = 0; i < n; i++) {
            if (i == 2) {
                continue;
            }
            if (i == 0 && chs[i] == '?') {
                if (chs[i + 1] >= '4' && chs[i + 1] != '?') {
                    chs[i] = '1';
                } else {
                    chs[i] = '2';
                }

            } else if (i == 1 && chs[i] == '?') {
                if (chs[i - 1] == '2') {
                    chs[i] = '3';
                } else {
                    chs[i] = '9';
                }
            } else if (i == 3 && chs[i] == '?') {
                chs[i] = '5';
            } else if (i == 4 && chs[i] == '?'){
                chs[i] = '9';
            } else {
                continue;
            }
        }
        return new String(chs);
    }

    public static void main(String[] args) {
        String a = "??:03";
        System.out.println(maximumTime(a));
    }
}
