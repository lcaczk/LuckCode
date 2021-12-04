package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 晋级人数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int x = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Collections.sort(list, Comparator.reverseOrder());
        int flag = list.get(x - 1);
        int count = 0;
        for (int num : list) {
            if (num != 0 && num >= flag) {
                count++;
            }
        }
        System.out.println(count);
    }
}
