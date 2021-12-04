package com.wkk.simulation.ali;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/22
 */
public class 比例问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sd = a / b;
        boolean flag = false;
        for (int i = x; i >= 1; i--) {
            if (i % sd == 0) {
                int rst = i / sd;
                if (rst <= y) {
                    System.out.println(i + " " + rst);
                    flag = true;
                    break;
                }
            }

        }
        if (flag) {
            System.out.println(0 + " " + 0);
        }
    }
}
