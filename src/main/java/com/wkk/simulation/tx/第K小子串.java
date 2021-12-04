package com.wkk.simulation.tx;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/18
 */
public class 第K小子串 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();
        int k = in.nextInt();
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            for (int len = 1; len <= 6; len++) {
                if (i + len <= n) {
                    set.add(s.substring(i, i + len));
                }

            }
        }
        List<String> list = new ArrayList<>(set);
        Collections.sort(list);
        System.out.println(list);
        System.out.println(list.get(k - 1));
    }
}
