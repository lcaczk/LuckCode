package com.wkk.string;

import java.util.Scanner;

/**
 * K-优字符串
 *
 * @author weikunkun
 * @since 2021/5/22
 */
public class AC_3333 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        for (int j = 1; j <= m; ++j) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            char[] chars = s.toCharArray();
            int count = 0;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                if (chars[left] != chars[right]) {
                    count++;
                }
                left++;
                right--;
            }
            int ans = Math.abs(count - k);
            System.out.println("Case #"+ j + ": " +ans);
        }
    }
}
