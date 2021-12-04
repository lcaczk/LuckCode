package com.wkk.simulation.newcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/12
 */
public class 彩色的砖块 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Set<Character> set = new HashSet<>();
        for (char ch : str.toCharArray()) {
            set.add(ch);
        }
        if (set.size() == 1) {
            System.out.println(1);
        } else if (set.size() == 2) {
            System.out.println(2);
        } else {
            System.out.println(0);
        }
    }
}
