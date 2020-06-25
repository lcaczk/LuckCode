package com.wkk.everyday.june;

/**
 * @Time: 2020/6/13上午8:21
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ClimbingStairs {
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        int a = 1;
        int b = 2;
        int temp;
        for(int i = 3; i<=n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return b;
    }
}
