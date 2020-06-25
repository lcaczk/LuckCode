package com.wkk.everyday.june;

/**
 * @Time: 2020/6/19上午8:44
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ValidPalindrome {
    public boolean isPalindromeII(String s){
        int low = 0;
        int height=  s.length()-1;
        while (low < height){
            while (low<height && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while (low<height && !Character.isLetterOrDigit(s.charAt(height))){
                height--;
            }
            if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(height))){
                return false;
            }
            low++;
            height--;
        }
        return true;

    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                sb.append(Character.toLowerCase(c));
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        ValidPalindrome validPalindrome = new ValidPalindrome();
        boolean palindrome = validPalindrome.isPalindrome(s);
        System.out.println(palindrome);
    }
}
