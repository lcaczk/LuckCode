package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/12/12
 */
public class LC_709 {
    public String toLowerCase(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        for (char ch : arr) {
            if (Character.isUpperCase(ch)) {
                sb.append(Character.toLowerCase(ch));
            } else {
                sb.append(ch);
            }
        }
        return  sb.toString();
    }
}
