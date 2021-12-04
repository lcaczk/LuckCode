package com.wkk.acwing.everyday;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/29
 */
public class 交换相邻元素 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = scan.nextInt();
        String can_str = scan.next();
        char[] can = can_str.toCharArray();

        boolean ok = true;
        int l = 0;
        int r = 0;
        while (r < n - 1) {
            if (can[r] == '1')
                r++;
            else {
                Arrays.sort(a, l, r + 1);
                r++;
                l = r;
            }
        }
        if (l < r)
            Arrays.sort(a, l, r + 1);

        if (ok == true) {
            for (int i = 0; i < n - 1; i++) {
                if (a[i] > a[i + 1]) {
                    ok = false;
                    break;
                }
            }
        }

        if (ok == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
