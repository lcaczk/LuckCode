package com.wkk.interview.bytedance2020;

/**
 * @Time: 2020/7/25上午10:16
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_AddStrings {
    public static String addStringsII(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int temp;
        // 其中一个遍历结束
        while(i>=0 && j>=0){
            int a = (int)(num1.charAt(i) - '0');
            int b = (int)(num2.charAt(j) - '0');
            temp = (a + b + carry)%10;
            carry = (a+b +carry)/10;
            sb.append(temp);
            i--;
            j--;
        }
        while(i >= 0){
            temp = (int)(num1.charAt(i) - '0')+ carry;
            sb.append(temp % 10);
            carry = temp /10;
            i--;
        }
        while(j >= 0){
            temp = (int)(num2.charAt(j) - '0') + carry;
            sb.append(temp % 10);
            carry = temp /10;
            j--;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();

    }

    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        StringBuilder sb = new StringBuilder();
        int temp;
        // 其中一个遍历结束
        while(i>=0 || j>=0){
            int a = i >= 0 ?(int)(num1.charAt(i) - '0'): 0;
            int b = j >= 0 ?(int)(num2.charAt(j) - '0'): 0;
            temp = (a + b + carry);
            carry = temp/10;
            sb.append(temp%10);
            i--;
            j--;
        }
        if(carry != 0){
            sb.append(carry);
        }
        return sb.reverse().toString();

    }
    public static void main(String[] args) {
        String a = "584";
        String b = "18";
        System.out.println(addStrings(a, b));
    }
}
