package com.wkk.simulation.aqy;

import java.util.HashSet;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/1
 */
public class DNA序列 {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        int n = input.length();
        for (int i = 1; i <= n; i++) {
            HashSet<String> set = new HashSet<>();
            for (int j = 0; j < n - i; j++) set.add(input.substring(j, j + i));
            if (set.size() < Math.pow(4, i)) {
                System.out.println(i);
                break;
            }
        }
    }
}
