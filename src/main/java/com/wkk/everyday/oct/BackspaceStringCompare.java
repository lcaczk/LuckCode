package com.wkk.everyday.oct;

/**
 * @author kongwiki@163.com
 * @since 2020/10/19
 */
public class BackspaceStringCompare {
    public boolean backspaceCompare(String S, String T) {
        S = vim(S);
        T = vim(T);
        return S.equals(T);
    }

    private String vim(String s){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s.length(); i++) {
            if(s.charAt(i) == '#') {
                if(sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                } else {
                    continue;
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
