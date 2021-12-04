package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/27
 */
public class 点 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = 0;
        // 求解x y 两点分开求解
        // ans = 所有元素的平方和 * n - 所有元素和的平方
        int[] xNums = new int[n];
        int[] yNums = new int[n];
        for (int i = 0; i < n; i++) {
            xNums[i] = sc.nextInt();
            yNums[i] = sc.nextInt();
        }
        ans = getRet(xNums, n) + getRet(yNums, n);
        System.out.println(ans);
    }

    public static long getRet(int[] nums, int n) {
        long ans = 0L;
        long powNum = 0L;
        long xSum = 0;
        for (int x : nums) {
            xSum += (long)x;
            powNum += (long)x * x;
        }
        ans = powNum * n - xSum * xSum;
        return ans;
    }
}

