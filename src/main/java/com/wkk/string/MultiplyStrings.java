package com.wkk.string;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringStack;

import java.util.Stack;

/**
 * @Time: 20-4-11下午1:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MultiplyStrings {
    public static String multiply(String num1, String num2) {
        if (num1.length() == 1 || num2.length() == 1) {
            int re = Integer.parseInt(num1) * Integer.parseInt(num2);
            return String.valueOf(re);
        }
        int cout = 1;
        long sum = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            String nums = getNums(num1.charAt(i), num2);
            sum += Long.parseLong(nums) * cout;
            cout *= 10;
        }
        return String.valueOf(sum);
    }

    public static String getNums(Character a, String b) {
        StringBuilder builder = new StringBuilder();
        Stack<Integer> stack = new Stack<>();
        int carry = 0;
        for (int i = b.length() - 1; i >= 0; i--) {
            int temp = (a - '0') * (b.charAt(i) - '0');
            int sum = temp + carry;
            carry = sum / 10;
            sum %= 10;
            stack.push(sum);
        }
        if (carry != 0) {
            stack.push(carry);
        }
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }

        return builder.toString();

    }


    public String multiplyII(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int p : pos) {
            if (!(sb.length() == 0 && p == 0)) {
                sb.append(p);
            }
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {

        String num1 = "498828660196";
        String num2 = "840477629533";
        String multiply = multiply(num1, num2);
        System.out.println(multiply);
//        System.out.println(Long.MAX_VALUE);
        System.out.println(Long.parseLong(num1) * Long.parseLong(num2));
    }
}
