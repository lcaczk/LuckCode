package com.wkk.greedy;

import java.util.Scanner;

/**
 * 三元数异或
 *
 * @author weikunkun
 * @since 2021/7/14
 */
public class AC_3764 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String nums = sc.nextLine();
            cal(nums, n);
        }
    }

    public static void cal(String str, int n) {
        char[] chs = str.toCharArray();
        // 贪心
        // 第一次遇到不能平均分时 1 : a + 1 b + 0
        // 后续继续，只要不是0 ： a + 0  b + num
        StringBuilder fist = new StringBuilder();
        StringBuilder second = new StringBuilder();
        boolean flag = false; // 记录第一次的不平均分的
        for (int i = 0; i < n; i++) {
            if (chs[i] == '2') {
                if (!flag) {
                    fist.append('1');
                    second.append('1');
                } else {
                    fist.append('0');
                    second.append('2');
                }
            } else if (chs[i] == '1') {
                if (!flag) {
                    fist.append('1');
                    second.append('0');
                    flag = true;
                } else {
                    fist.append('0');
                    second.append('1');
                }
            } else {
                fist.append('0');
                second.append('0');
            }
        }
        System.out.println(fist.toString());
        System.out.println(second.toString());
    }
}
