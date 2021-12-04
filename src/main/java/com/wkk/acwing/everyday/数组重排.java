package com.wkk.acwing.everyday;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 数组重排 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = Integer.parseInt(sc.nextLine());
        int count = 0;
        while (count < group) {
            if (count != 0) {
                sc.nextLine();
            }
            String[] line = sc.nextLine().split(" ");
            int target = Integer.parseInt(line[1]);
            int n = Integer.parseInt(line[0]);
            List<Integer> first = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            List<Integer> second = Arrays.stream(sc.nextLine().split(" "))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            Collections.sort(first);
            Collections.sort(second, Comparator.reverseOrder());
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                if (first.get(i) + second.get(i) > target) {
                    flag = true;
                }
            }

            if (flag) {
                System.out.println("No");
            } else {
                System.out.println("Yes");
            }
            count++;
        }
    }
}
