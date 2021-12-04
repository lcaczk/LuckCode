package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_28 {
    public static int strStrI(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    public static int strStrII(String haystack, String needle) {
        if (haystack == null) {
            return -1;
        }
        if (needle == null || needle.length() == 0) {
            return 0;
        }
        char[] large = haystack.toCharArray();
        char[] small = needle.toCharArray();
        int n = large.length;
        int m = small.length;
        if (m > n) {
            return -1;
        }
        int i = 0;
        int flag = -1;
        while (i < n){
            if (large[i] != small[0]) {
                i++;
                continue;
            }
            flag = i;
            int j = 0;
            while (i < n && j < m && small[j] == large[i]) {
                j++;
                i++;
            }
            if (j == m) {
                return flag;
            }
            i = flag + 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        strStrI("mississippi","issip");
    }
}
