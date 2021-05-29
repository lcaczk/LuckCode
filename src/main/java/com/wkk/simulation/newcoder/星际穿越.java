package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * 思路：
 * 求 x + x ^ 2
 * 适用二分查找
 * 注意判断条件
 * @author weikunkun
 * @since 2021/5/29
 */
public class 星际穿越 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLong()) {
            long num = sc.nextLong();
            System.out.println(cal(num));
        }
    }

    private static long cal(long num) {
        long left = 0;
        long right = num;
        while (left < right) {
            long mid = (left +right + 1) / 2;
            if (genR(mid, num)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    private static boolean genR(long num, long target) {
        // 精度问题
        long rst = target / (num + 1);
        return rst < num;
    }
}
