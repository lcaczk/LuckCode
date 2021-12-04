package com.wkk.string;

/**
 * 43 字符串相乘
 * @author weikunkun
 * @since 2021/7/18
 */
public class LC_43 {
    public static String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] first = num1.toCharArray();
        char[] second = num2.toCharArray();
        int m = first.length;
        int n = second.length;
        String res = "0";
        int carry = 0;
        int tmp;
        int innerCur;
        int flag = 0;
        for (int i = n - 1; i >= 0; i--) {
            int cur = second[i] - '0';
            int j = m - 1;
            StringBuilder sb = new StringBuilder();
            int k = 0;
            while (k < flag) {
                sb.append("0");
                k++;
            }
            while (j >= 0) {
                innerCur = first[j--] - '0';
                tmp = innerCur * cur + carry;
                sb.append(tmp % 10);
                carry = tmp / 10;
            }
            if (carry != 0) {
                sb.append(carry);
            }
            res = twoSum(res, sb.reverse().toString());
            flag++;
            carry = 0;
        }
        return res;
    }

    private static String twoSum(String first, String second) {
        char[] a = first.toCharArray();
        char[] b = second.toCharArray();
        int flag = 0;
        StringBuilder sb = new StringBuilder();
        int m = a.length;
        int n = b.length;
        int i = m - 1;
        int j = n - 1;
        int left = 0;
        int right = 0;
        int carry = 0;
        while (i >= 0 && j >= 0) {
            left = a[i--] - '0';
            right = b[j--] - '0';
            int sum = left + right + carry;
            sb.append(sum % 10);
            carry = sum / 10;
        }

        while (i >= 0) {
            int sum = a[i] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            i--;
        }

        while (j >= 0) {
            int sum = b[j] - '0' + carry;
            sb.append(sum % 10);
            carry = sum / 10;
            j--;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "9";
        String b = "99";
        System.out.println(multiply(a, b));
    }
}
