package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/7
 */
public class 链表合并 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String first = sc.nextLine();
            String second = sc.nextLine();
            String[] a = first.split(" ");
            String[] b = second.split(" ");
            int len1 = a.length;
            int len2 = b.length;
            int i = 0;
            int j = 0;
            String[] ans = new String[len2 + len1];
            int idx = 0;
            while (i < len1 && j < len2) {
                if (a[i].compareTo(b[j]) < 0) {
                    ans[idx++] = a[i++];
                } else {
                    ans[idx++] = b[j++];
                }
            }
            while (i < len1) {
                ans[idx++] = a[i];
                i++;
            }
            while (j < len2) {
                ans[idx++] = b[j];
                j++;
            }
            for (String num : ans) {
                System.out.print(num + " ");
            }
        }
    }
}
