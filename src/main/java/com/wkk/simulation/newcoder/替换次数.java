package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/7
 */
public class 替换次数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int oper = sc.nextInt();
        String str = sc.next();
        System.out.println(genAns(str, len, oper));

    }

    private static int genAns(String str, int len, int oper) {
        int left = 0;
        int right = 0;
        int res = 0;
        int a = 0;
        int b = 0;
        char[] arr = str.toCharArray();
        while (right < len) {
            if (arr[right] == 'a') {
                a++;
            } else if (arr[right] == 'b') {
                b++;
            }
            if (a <= oper || b <= oper) {
                right++;
            } else {
                res = Math.max(res, right - left);
                if (arr[left] == 'a') {
                    a--;
                    left++;
                } else {
                    b--;
                    left++;
                }
                right++;
            }
        }

        res = Math.max(res, right - left);
        return res;
    }
}
