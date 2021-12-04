package com.wkk.simulation.mt;

import java.math.BigDecimal;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class 小美的评分计算器 {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
        System.out.println(Math.floorDiv(100, 3));

        BigDecimal decimal = new BigDecimal("10.25");
        int a = 8;
        double v = 23 / (double) 8;
        BigDecimal bigDecimal = new BigDecimal(v);
        float l = decimal.setScale(1, BigDecimal.ROUND_FLOOR).floatValue();
        System.out.println(l);
//        System.out.println();
    }
}
