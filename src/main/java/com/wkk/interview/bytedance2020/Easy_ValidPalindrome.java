package com.wkk.interview.bytedance2020;

/**
 * @Time: 2020/7/25上午9:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_ValidPalindrome {
    public boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() -1;
        while (i < j){
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            else {
                i++;
                j--;
            }
        }
        return true;
    }
}
