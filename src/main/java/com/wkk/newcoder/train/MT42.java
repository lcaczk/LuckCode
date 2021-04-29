package com.wkk.newcoder.train;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/29
 */
public class MT42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int first = sc.nextInt();
            int second = sc.nextInt();
            int temp = first ^ second;
            int coutNumber = 0;
            while (temp != 0) {
                coutNumber += 1;
                temp = (temp & (temp - 1));
            }
            System.out.println(coutNumber);
        }
    }
}
