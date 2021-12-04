package com.wkk.binarysearch;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/6/18
 */
public class LC_483 {
    public static String smallestGoodBase(String n) {
        long N = Long.parseLong(n);
        //对任意数字，它最少可以用2位表示（11），此时的进制位 N - 1 进制，如 13 用“11”表示，此时是12进制
        long ans = N - 1;
        //遍历数字能转化 k 进制的位数
        for(int i = 2; i < 60; i++){
            //二分查找 k的值
            long l = 2, r = N;
            while(l < r){
                long mid = l + (r - l) / 2;
                //计算 mid 进制下，位数为 i 的数字大小
                long temp = isGoodNum(mid, i, N);
                //如果两者相等，说明 mid 是 n 的一个好进制
                if(temp == N){
                    ans = Math.min(ans, mid);
                    break;
                }else if(temp > N){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }
        }
        return String.valueOf(ans);
    }

    //计算 k 进制下，位数为 m 的数字大小
    private static long isGoodNum(long k, int m, long N){
        long num = 0;
        for(int i = 0; i < m; i++){
            num = num * k + 1;
            //放置数字溢出，如果溢出，则说明返回值肯定大于 N ，直接返回 N + 1
            if(i < m - 1 && num > (N - 1) / k){
                return N + 1;
            }
        }
        return num;
    }


    public static void main(String[] args) {
        smallestGoodBase("25");
        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(1);
        deque.pop();
    }
}
