package com.wkk.simulation.newcoder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/15
 */
public class 塔 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        List<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }
        cal(arr, k);
    }

    private static void cal(List<Integer> arr, int k) {
        List<Integer> from = new ArrayList<>();
        List<Integer> to = new ArrayList<>();
        int max = Collections.max(arr);
        int min = Collections.min(arr);
        int count = 0;
        while (k-- > 0 && max - min > 1) {
            from.add(arr.indexOf(max) + 1);
            to.add(arr.indexOf(min) + 1);
            arr.set(arr.indexOf(max), max - 1);
            arr.set(arr.indexOf(min), min + 1);
            max = Collections.max(arr);
            min = Collections.min(arr);
            count++;
        }
        max = Collections.max(arr);
        min = Collections.min(arr);
        System.out.println((max - min) + " " + count);
        for (int i = 0; i < from.size(); i++) {
            System.out.println(from.get(i) + " " + to.get(i));
        }

    }
}
