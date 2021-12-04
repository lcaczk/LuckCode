package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/29
 */
public class 偏爱字母 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        System.out.println(cal(str, n));
    }

    /**
     * 模拟 超时了
     * @param str
     * @param n
     * @return
     */
    private static int cal(String str, int n) {
        // 模拟
        char[] chs = str.toCharArray();
        int max = Integer.MIN_VALUE;
        int countF;
        int countE;
        for (int i = 0; i < n; i++) {
            int j = i;
            countE = 0;
            countF = 0;
            while (j < n) {
                if (chs[j] == 'F') {
                    countF++;
                } else if (chs[j] == 'E') {
                    countE++;
                }
                j++;
                if (countE > countF) {
                    max = Math.max(max, countE - countF);
                }
            }
        }
        return max;
    }
}
