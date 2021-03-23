package com.wkk.bytedance2021.string;

/**
 * @author weikunkun
 * @since 2021/3/23
 */
public class LC_AAA {
    private static final char A = 'A';
    private static final char B = 'L';

    public boolean checkRecord(String s) {
        // 遍历两次 s
        int len = s.length();
        int i = 0;
        int ACount = 1;
        while (i < len) {
            if (s.charAt(i) == A) {
                ACount--;
            }
            i++;
        }
        if (ACount < 0) {
            return false;
        }
        i = 0;
        while (i < len) {
            // 如果迟到 查找连续次数
            if (s.charAt(i) == B) {
                int j = i + 1;
                while (j < len && s.charAt(j) == B) {
                    j++;
                }
                if ((j - i) > 2) {
                    return false;
                }
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String a = "PPALLP";
        LC_AAA lc_aaa = new LC_AAA();
        lc_aaa.checkRecord(a);
    }
}
