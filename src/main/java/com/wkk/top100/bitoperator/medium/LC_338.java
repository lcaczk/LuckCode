package com.wkk.top100.bitoperator.medium;

/**
 * 338 比特位计算
 *
 * @author weikunkun
 * @since 2021/2/16
 */
public class LC_338 {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            result[i] = countOne(i);
        }
        return result;
    }

    private int countOne(int num) {
        int count = 0;
        while (num > 0) {
            count++;
            num = (num & (num - 1));
        }
        return count;
    }

    // 根据位的特性，每增加一个高位的1，可近似理解为数字大小变为原先的2倍
    public int[] countBitsII(int nums) {
        int[] dp = new int[nums + 1];
        dp[0] = 0;
        for (int i = 1; i <= nums; i++) {
            dp[i] = dp[i/2] + i%2;
        }
        return dp;
    }

}
