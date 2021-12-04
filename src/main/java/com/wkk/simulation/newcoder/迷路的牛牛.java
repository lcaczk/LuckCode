package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/8
 */
public class 迷路的牛牛 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String times = sc.next();
        char[] arr = times.toCharArray();
        int pos = 0;
        for (char ch : arr) {
            if (ch == 'L') {
                pos--;
            } else {
                pos++;
            }
        }
        int ans = pos % 4 < 0 ? pos % 4 + 4 : pos % 4;
        String[] res = {"N", "E", "S", "W"};
        System.out.println(res[ans]);
    }
}
