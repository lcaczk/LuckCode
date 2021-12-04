package com.wkk.simulation.aqy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/1
 */
public class 湖泊抽水问题 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = split.length;
        List<Integer> tmp = new ArrayList<>();
        String a = split[0].substring(1, 2);
        String b = split[n - 1].substring(0, 1);
        tmp.add(Integer.valueOf(a));
        for (int i = 1; i < n - 1; i++) {
            tmp.add(Integer.parseInt(split[i]));
        }
        tmp.add(Integer.parseInt(b));
        int[] array = tmp.stream().mapToInt(Integer::intValue).toArray();
        cal(array, array.length);
    }

    private static void cal(int[] array, int n) {
        int[] ans = new int[n];
        boolean[] full = new boolean[n + 1];
        boolean[] remove = new boolean[n + 1];
        for (int i = 0; i < n; i++) {
            if (array[i] != 0) {
                ans[i] = -1;
                if (full[i + 1]) {
                    System.out.println("-1");
                    break;
                }
                full[i + 1] = true;
            } else {
                int j = i + 1;
                while (array[j] == 0 || !full[array[j]] || remove[array[j]]) {
                    j++;
                }
                int nextFull = array[j];
                full[array[j]] = false;
                remove[nextFull] = true;
                ans[i] = nextFull;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int an : ans) {
            sb.append(an);
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void print(List<Integer> list) {
        list.forEach(System.out::println);
    }
}
