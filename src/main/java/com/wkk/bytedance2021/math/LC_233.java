package com.wkk.bytedance2021.math;

/**
 * @author weikunkun
 * @since 2021/3/24
 */
public class LC_233 {
    public int countDigitOne(int n) {
        // 不用暴力循环1-n个数字
        // 统计每一位1的次数
        // 1. 该位 = xxx 1 y
        // 2. 该位 = xxx 0 y
        // 3. 该位 = xxx [2-9] y
        // 举例说明
        // 235 0 3  高位 000-234 当前位 1  低位 0-9  235 * 10 种
        //          高位 235     当前位 0  低位 0-3  0        种     高位 * 10
        // 235 1 3  高位 000-234 当前位 1  低位 0-9  235 * 10 种
        //          高位 235     当前位 1  低位 0-3  4        种     高位 * 10 + 低位 + 1
        // 235 9 3  高位 000-234 当前位 1  低位 0-9  235 * 10 种
        //          高位 235     当前位 1  低位 0-9  10       种     高位 * 10 + 10 = （高位+1） * 10
        int sum = 0;
        int high = n / 10;
        int low = 0;
        int cur = n % 10;
        int digit = 1;
        while (high != 0 || cur != 0) {
            if (cur == 0) {
                sum += high * digit;
            } else if (cur == 1) {
                sum += high * digit + low + 1;
            } else {
                sum += (high + 1) * digit;
            }
            low += cur * digit;
            cur = high % 10;
            high /= 10;
            digit *= 10;
        }
        return sum;
    }
}
