package com.wkk.simulation.mt;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class 修改大小写 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Map<Integer, Integer> map = new HashMap<>();
        char[] chs = str.toCharArray();
        int upper = 0;
        int lower = 0;
        for (char ch : chs) {
            if (Character.isLowerCase(ch)) {
                lower++;
            } else {
                upper++;
            }
        }
        int diff = Math.abs(upper - lower);
        System.out.println(diff / 2);
    }
}
