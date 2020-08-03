package com.wkk.string;

/**
 * @author kongwiki@163.com
 * @since 2020/8/2下午4:55
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        if(s.length() < 2){
            return s;
        }
        String res = s.substring(0, 1);
        int max = 1;
        for(int i = 0; i<s.length(); i++){
            String odd = getMaxLen(s, i, i);
            String even = getMaxLen(s, i, i+1);
            String temp = odd.length()>even.length() ? odd : even;
            if(temp.length() > max){
                res = temp;
                max = temp.length();
            }
        }
        return res;
    }

    private String getMaxLen(String s, int left, int right){
        int n = s.length();
        while(left>=0 && right<n){
            if(s.charAt(left) == s.charAt(right)){
                left--;
                right++;
            }else {
                break;
            }
        }
        return s.substring(left+1, right);
    }
}
