package com.wkk.acwing.everyday;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/23
 */
public class AC_3814 {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int res = 1;
        String line;
        for (int i = 0; i < n; i++) {
            line = sc.nextLine();
            map.put(line, map.getOrDefault(line,0) +1);
            res = Math.max(res, map.get(line));
        }
        System.out.println(res);
    }
}
