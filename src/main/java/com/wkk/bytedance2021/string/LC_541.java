package com.wkk.bytedance2021.string;

/**
 * @author weikunkun
 * @since 2021/4/15
 */
public class LC_541 {
    public String reverseStr(String s, int k) {
        char[] ch = s.toCharArray();
        int len = ch.length;
        for (int i = 0; i < len; i += 2 * k) {
            int left = i;
            int right = Math.min(i + k - 1, len - 1);
            while (left < right) {
                char temp = ch[left];
                ch[left] = ch[right];
                ch[right] = temp;
                left++;
                right--;
            }
        }
        return new String(ch);
    }
}
