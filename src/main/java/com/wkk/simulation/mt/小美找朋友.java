package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class 小美找朋友 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] line = sc.nextLine().split(" ");
        int bigLen = Integer.parseInt(line[0]);
        int smallLen = Integer.parseInt(line[1]);
        String big = sc.nextLine();
        String small = sc.nextLine();
        isContain(big, small, bigLen, smallLen);
    }

    public static void isContain(String str1, String str2, int m, int n) {
        int i = 0;
        int j = 0;
        Map<Character, List<Integer>> map = new HashMap<>();
        while (i < m) {
            if (str1.charAt(i) == str2.charAt(j)) {
                map.computeIfAbsent(str2.charAt(j),k -> new ArrayList<>()).add(i + 1);
                j++;
            }
            i++;
        }
        if (j == n) {
            System.out.println("Yes");
            long sum = 0;
            for (List<Integer> value : map.values()) {
                sum += value.stream().mapToInt(k->k).sum();
            }
            System.out.println(sum);
//            System.out.println(Arrays.stream(map.values().stream().mapToInt(k -> k).toArray()).sum());
        } else {
            System.out.println("No");
        }
    }
}
