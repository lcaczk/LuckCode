package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/18
 */
public class 回文子序列 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            if (n < 3) {
                System.out.println("NO");
            }
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n - 1; i++) {
                int odd = isSame(arr, i, i);
                int even = isSame(arr, i, i + 1);
                max = Math.max(max, Math.max(odd, even));
                if (max >= 3) {
                    System.out.println("YES");
                    break;
                }
            }
            if (max >= 3) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static int isSame(int[] arr, int left, int right) {
        int n = arr.length;
        while (left >= 0 && right < n) {
            if (arr[left] == arr[right]) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return right - left - 1;
    }
}
