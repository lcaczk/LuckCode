package com.wkk.simulation.lc;

/**
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_5786 {
    public static int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2 + 1;
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i <= mid; i++) {
                sb.setCharAt(removable[i], ' ');
            }
            if (!isSubstring(sb.toString(), p)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        if (left == 0) {
            StringBuilder sb = new StringBuilder(s);
            sb.setCharAt(removable[0], ' ');
            if (isSubstring(sb.toString(), p)) {
                return 1;
            } else {
                return 0;
            }
        }
        return left + 1;
    }

    private static boolean isSubstring(String s, String p) {
        int n = s.length();
        int m = p.length();
        int i = 0;
        int j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == p.charAt(j)) {
                j++;
            }
            i++;
        }
        return j == m;
    }

    public static boolean isSubsequence(String s, String p) {// 判断p是否是s的子串
        int n = p.length(), m = s.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (p.charAt(i) == s.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    public static void main(String[] args) {
        String a = "abcbddddd";
        String b = "abcd";
        int[] c = {3, 2, 1, 4, 5, 6};
        System.out.println(maximumRemovals(a, b, c));
    }
}
