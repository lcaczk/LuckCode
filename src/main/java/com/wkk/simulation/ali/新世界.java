package com.wkk.simulation.ali;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/6
 */
public class 新世界 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int d = sc.nextInt();
        int m = sc.nextInt();
        int w = sc.nextInt();
        // k 年 j 月 i 天
        int i = sc.nextInt();
        int j = sc.nextInt();
        int k = sc.nextInt();
        cal(d, m, w, i, j, k);
    }

    /**
     * @param d
     * @param m
     * @param w
     * @param i
     * @param j
     * @param k
     */
    private static void cal(int d, int m, int w, int i, int j, int k) {
        // map key 天  value  字母
        Map<Integer, Character> map = new HashMap<>();
        String day = "abcdefghijklmnopqrstuvwxyz";
        char[] chars = day.toCharArray();
        for (int i1 = 1; i1 <= w; i1++) {
            if (i1 == w) {
                map.put(0, chars[i1 - 1]);
            } else {
                map.put(i1, chars[i1 - 1]);
            }
        }
        BigDecimal one = new BigDecimal(1);
        BigDecimal year = new BigDecimal(k);
        BigDecimal subYear = year.subtract(one);
        BigDecimal month = new BigDecimal(j);
        BigDecimal subMonth = month.subtract(one);
        BigDecimal readDay = new BigDecimal(d);
        BigDecimal da = new BigDecimal(i);
        BigDecimal weak = new BigDecimal(w);
        BigDecimal totalDay = subYear.multiply(month).multiply(readDay);
        BigDecimal totalDay2 = subMonth.multiply(readDay);
        BigDecimal realTotalDay = totalDay2.add(totalDay).add(da);
        BigDecimal[] bigDecimals = realTotalDay.divideAndRemainder(weak);
        int rest = bigDecimals[1].intValue();
        System.out.println(map.get(rest));
//        long total = (k - 1) * m + (j - 1) * d + i;
//        int rst = (int) total % w;
//        System.out.println(map.get(rst));
    }
}
