package com.wkk.everyday.aug;

/**
 * @author kongwiki@163.com
 * @since 2020/8/19上午8:50
 */
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if(s == null || s.length() == 0){
            return 0;
        }
        int count = s.length();
        // 循环检测是是否为回文子串
        for(int i = 0; i<s.length(); i++){
            for(int j = i+1; j<s.length(); j++){
                String temp = s.substring(i, j+1);
                 if(isPalindromic(temp, 0, temp.length()-1)){
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isPalindromic(String s, int i , int j){
        if(i > j){
            return false;
        }
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "bbca";
        PalindromicSubstrings substrings = new PalindromicSubstrings();
        int i = substrings.countSubstrings(s);
        System.out.println(i);
    }
}
