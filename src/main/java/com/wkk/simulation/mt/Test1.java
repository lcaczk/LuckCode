package com.wkk.simulation.mt;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/8/8
 */
public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> set = new HashSet<>();
        char[] chs = str.toCharArray();
        int n = str.length();
        StringBuilder sb = new StringBuilder();
        char pre = '#';
        for (int i = 0; i < n; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            if (chs[i] == pre) {
                continue;
            }
            pre = chs[i];
            sb.append(chs[i]);
        }
        System.out.println(sb.toString());
    }
}
