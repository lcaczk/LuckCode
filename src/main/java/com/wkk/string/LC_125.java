package com.wkk.string;

/**
 * @author weikunkun
 * @since 2021/7/18
 */
public class LC_125 {
    public static boolean isPalindrome(String s) {
        int i = 0;
        int j = s.length() -1;
        while(i < j){
            // 先去除不是字符的位置
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            // 为字符的部分
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))){
                return false;
            }
            else{
                i++;
                j--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        isPalindrome("race a car");
    }
}
