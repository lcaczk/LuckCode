package com.wkk.simulation.tx;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/5
 */
public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        cal(str, n);
    }

    private static void cal(String str, int n) {
        char[] arr = str.toCharArray();
        int a = 0;
        int b = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == '0') {
                a++;
            } else {
                b++;
            }
        }
        int c = 0;
        int d = n - 1;
        if (a > b) {
            while (arr[c] == '1') {
                c++;
            }
            while (arr[d] == '1') {
                d--;
            }
            int ans = (1 + c) * c / 2 + (1 + a) * a / 2 + (n -d) * (n - d - 1) / 2;
            System.out.println(ans);
        } else if (a < b) {
            while (arr[c] == '0') {
                c++;
            }
            while (arr[d] == '0') {
                d--;
            }
            int ans = (1 + c) * c /2 + (1 + b) * b / 2 + (n - d) * (n - d - 1) / 2;
            System.out.println(ans);
        } else {
            while (arr[c] == '0') {
                c++;
            }
            while (arr[d] == '0') {
                d--;
            }
            int e = 0;
            int f = n - 1;
            while (arr[e] == '1') {
                e++;
            }
            while (arr[f] == '1') {
                f--;
            }

            if (c * d > e * f) {
                int ans = (1 + c) * c /2 + (1 + a) * a / 2 + (n - d) * (n - d - 1) / 2;
                System.out.println(ans);
            } else if (c + d < e * f) {
                int ans = (1 + e) * e /2 + (1 + b) * b / 2 + (n - f) * (n - f - 1) / 2;
                System.out.println(ans);
            } else {
                if (c == 0) {
                    int ans = (1 + a) * a /2 + (n - d) * (n - d - 1) / 2;
                    System.out.println(ans);
                } else if (d == 0) {
                    int ans = (1 + c) * c / 2  + (1 + a) * a / 2;
                    System.out.println(ans);
                }
            }
        }

    }
}
