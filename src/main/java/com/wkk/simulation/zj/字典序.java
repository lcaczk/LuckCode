package com.wkk.simulation.zj;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class 字典序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long m = sc.nextLong();
        long ans = findKthNumber(n, m);
        System.out.println(ans);
    }

    public static long findKthNumber(long n, long k) {
        long cur = 1;
        k = k-1;
        while (k > 0){
            long nodes = getNodes(n, cur, cur + 1);
            // 不在cur - cur+1 之间
            if(nodes <= k){
                cur += 1;
                k -= nodes;
            }else {
                cur *= 10;
                k-= 1;
            }
        }
        return cur;
    }

    // 获取每一层的节点个数
    private static long getNodes(long n, long left, long right){
        long nums = 0;
        while (left <= n){
            nums += Math.min(n+1, right) - left;
            left *= 10;
            right *= 10;
        }
        return nums;
    }
}
