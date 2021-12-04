package com.wkk.simulation.aqy;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/1
 */
public class 循环数字比较 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int x1 = sc.nextInt();
        int k1 = sc.nextInt();
        int x2 = sc.nextInt();
        int k2 = sc.nextInt();
        compare(x1, k1, x2, k2);
    }

    public static void compare(int x1, int k1, int x2, int k2) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        while (k1-- > 0) sb1.append(x1 + "");
        while (k2-- > 0) sb2.append(x2 + "");
        int l1 = sb1.length(), l2 = sb2.length();
        if (l1 > l2) {
            System.out.println("Greater");
            return;
        } else if (l1 < l2) {
            System.out.println("Less");
            return;
        }
        for (int i = 0; i < l1; ++i)
            if (sb1.charAt(i) > sb2.charAt(i)) {
                System.out.println("Greater");
                return;
            } else if (sb1.charAt(i) < sb2.charAt(i)) {
                System.out.println("Less");
                return;
            }
        System.out.println("Equal");
    }
}
