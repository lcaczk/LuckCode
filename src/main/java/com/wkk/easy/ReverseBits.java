package com.wkk.easy;

/**
 * @Time: 20-3-24上午11:06
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ReverseBits {
    /**
     * 反转给定32位无符号整数的位
     * @param n 给的32位数
     * @return
     */
    public static int reverseBits(int n){
        int res = 0;
        for (int i = 0; i < 32; i++) {
            res = (res<<1) | (n &1);
            n = n>>1;
        }
        return res;
    }

    public static void main(String[] args) {
//        int a = 0;
//        System.out.println(a<<1);
        int n = 101;
        System.out.println(n&1);
//        int i = reverseBits(n);
//        System.out.println(i);
    }
}
