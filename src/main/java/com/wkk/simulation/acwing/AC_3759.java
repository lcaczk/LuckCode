package com.wkk.simulation.acwing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/7/10
 */
public class AC_3759 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String ans = cal(n, k);
            System.out.println(ans);
        }
        List<String> list = new ArrayList<>(Arrays.asList("bbaa", "baba", "baab"));
        List<String> tmp = list.stream().sorted().collect(Collectors.toList());
        System.out.println(tmp);
    }

    private static String cal(int n, int target) {
        for (int i = n - 1; i >= 0; i--) {
            if (target > n - i) {
                target -= n - i;
            } else {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < n; j++) {
                    if (j == i - 1 || j == n - target) {
                        sb.append("b");
                    } else {
                        sb.append("a");
                    }
                }
                return sb.toString();
            }

        }
        return "";
    }
}
