package com.wkk.simulation.newcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/12
 */
public class 计算糖果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        System.out.println(cal(list));
    }

    private static String cal(List<Integer> list) {
        int a = (list.get(0) + list.get(2)) / 2;
        if (a * 2 != list.get(0) + list.get(2)) {
            return "No";
        }
        int b = (list.get(2) - list.get(0)) / 2;
        if (b * 2 != list.get(2) - list.get(0)) {
            return "No";
        }
        int c = (list.get(3) - list.get(1)) / 2;
        if (c * 2 != list.get(3) - list.get(1)) {
            return "No";
        }
        if (list.get(2) < 0 || list.get(3) < 0) {
            return "No";
        }
        return a + " " + b + " " + c;
    }
}
