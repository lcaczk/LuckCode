package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/10/15
 */
public class lC_38 {
    public String countAndSay(int _n) {
        // 思路：
        // 递归
        if (_n <= 2) {
            if (_n == 1) {
                return "1";
            }
            return "11";
        }
        String pre = countAndSay(_n - 1);
        char[] array = pre.toCharArray();
        int n = array.length;
        StringBuilder sb = new StringBuilder();
        int i = 1;
        int j = 0;
        while (i < n) {
            if (array[i] != array[i - 1]) {
                int num = i - j;
                sb.append(num);
                sb.append(array[j]);
                j = i;
            }
            i++;
        }
        int num = i - j;
        sb.append(num);
        sb.append(array[j]);
        return sb.toString();
    }
}
