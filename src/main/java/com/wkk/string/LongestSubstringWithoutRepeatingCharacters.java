package com.wkk.string;

/**
 * @Time: 20-4-2上午11:12
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int i, j, max, c, n = s.length();
        if (s == null || n < 1) {
            return 0;
        }
        char[] b = s.toCharArray();
        max = 0;
        c = 0;
        // i为中心位置
        for (i = 0; i < n; i++) {

            // 回文字符串为奇数
            for (j = 0; (i - j >= 0) && (i + j <= n); j++) {
                if (b[i - j] != b[i + j]) {
                    break;
                }
                c = j * 2 + 1;
            }
            if (c > max) {
                max = c;
            }

            // 回文长度为偶数
            for (j = 0; (i - j >= 0) && (i + j + 1 < n); j++) {
                if (b[i - j] != b[i + j + 1]) {
                    break;
                }
                c = j * 2 + 2;
            }

            if (c > max) {
                max = c;
            }
        }
        return max;
    }
}
