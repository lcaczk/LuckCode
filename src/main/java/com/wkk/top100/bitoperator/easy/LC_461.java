package com.wkk.top100.bitoperator.easy;

/**
 * 汉明距离
 * ^之后，使用(num&(num-1))统计1的个数
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_461 {
    public int hammingDistance(int x, int y) {
        int num = x ^ y;
        int count = 0;
        while (num > 0) {
            num = (num & (num - 1));
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int x = 1;
        int y = 4;
        LC_461 lc_461 = new LC_461();
        System.out.println(lc_461.hammingDistance(x, y));
    }
}
