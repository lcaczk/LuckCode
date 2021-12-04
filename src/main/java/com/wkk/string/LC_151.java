package com.wkk.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/7/18
 */
public class LC_151 {
    public String reverseWords(String s) {
        int n = s.length();
        char[] chs = s.toCharArray();
        for (int i = 0; i < n; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            int j = i + 1;
            while (j < n && chs[j] != ' ') {
                j++;
            }
            swap(chs, i, j - 1);
            i = j;
        }
        // 从后往前放入元素
        StringBuilder sb = new StringBuilder();
        for (int i = n - 1; i >= 0; i--) {
            if (chs[i] == ' ') {
                continue;
            }
            int j = i;
            while (j >= 0 && chs[j] != ' ') {
                j--;
            }
            sb.append(s.substring(j + 1, i + 1));
            sb.append(" ");
            i = j;
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    private void swap(char[] chs, int i, int j) {
        while (i < j) {
            char tmp = chs[i];
            chs[i] = chs[j];
            chs[j] = tmp;
            i++;
            j--;
        }
    }

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
    }
}
