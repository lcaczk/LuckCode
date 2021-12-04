package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/9/7
 */
public class lC_1221 {
    public static int balancedStringSplit(String s) {
        char[] arr = s.toCharArray();
        // 模拟
        int l = 0;
        int r = 0;
        int count = 0;
        int i = 0;
        int n = arr.length;
        while (i < n) {
            if (arr[i] == 'L') {
                l++;
            } else {
                r++;
            }

            if (l == r) {
                count++;
                l = 0;
                r = 0;
            }
            i++;
        }
        return count;
    }

    public static void main(String[] args) {
        balancedStringSplit("RLLLLRRRLR");
    }
}
