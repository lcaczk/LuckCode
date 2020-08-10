package com.wkk.top.twopointer;

/**
 * @author kongwiki@163.com
 * @since 2020/8/8上午10:54
 */
public class ValidPalindromeII {
    public static boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                if (helper(s, i + 1, j) || helper(s, i, j - 1)) {
                    return true;
                } else {
                    return false;
                }
            }
            i++;
            j--;
        }
        return true;
    }

    // 删除左/右一个元素后, 查看是否相同
    private static boolean helper(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcbca";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }
}
