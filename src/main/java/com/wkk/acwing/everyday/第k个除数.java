package com.wkk.acwing.everyday;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/28
 */
public class 第k个除数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long a = sc.nextLong();
        int b = sc.nextInt();
        // 思路
        // 求所有的结果，然后排序 求第k个
        // 直接暴力 边求变计算结果
        cal(a, b);
    }

    private static void cal(long num, int k) {
        List<Long> list = new ArrayList<>();
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                list.add(i);
                list.add(num / i);
            }
        }
        Collections.sort(list);
        if (k > list.size()) {
            System.out.println(-1);
        } else {
            System.out.println(list.get(k - 1));
        }
    }
}
