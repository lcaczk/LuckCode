package com.wkk.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/10/3
 */
public class LC_166 {
    public static String fractionToDecimal(int numerator, int denominator) {
        // 正常运算
        // 1. 整除
        // 2. 小数
        // 3. 无限循环
        // 思路
        // 通过stringbuilder存储结果
        // 模拟除法
        // 使用map 存储每次的余数 如何当前计算的结果已经包含了，这算出循环区间 返回
        long a = numerator;
        long b = denominator;
        if (a % b == 0) {
            return String.valueOf(a / b);
        }
        StringBuilder sb = new StringBuilder();
        if (a * b < 0) {
            sb.append("-");
        }
        a = Math.abs(a);
        b = Math.abs(b);
        sb.append(a / b);
        sb.append(".");
        a %= b;
        // 开始计算小数部分
        Map<Long, Integer> map = new HashMap<>();
        int idx = sb.length();
        while (a != 0) {
            map.put(a, idx);
            a *= 10;
            sb.append(a / b);
            a %= b;
            if (map.containsKey(a)) {
                // 计算出循环区间
                int u = map.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
            idx++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(fractionToDecimal(-2147483648, -1));
        System.out.println(Integer.MAX_VALUE);
        System.out.println((long)Math.pow(2, 31));
    }

}
