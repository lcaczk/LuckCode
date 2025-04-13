package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2022/1/22
 */
public class AC_4212 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String first = sc.next().toLowerCase();
        String second = sc.next().toLowerCase();
        int result = first.compareTo(second);
        if (result > 0) {
            System.out.println(1);
        } else if (result < 0) {
            System.out.println(-1);
        } else {
            System.out.println(0);
        }
    }
}
