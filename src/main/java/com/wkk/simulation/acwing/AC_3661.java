package com.wkk.simulation.acwing;


import java.util.Scanner;

/**
 * 详见 安置路灯思路
 * 不过 对于选择标准值，没有想到好方式，直接使用暴力求解
 * @author weikunkun
 * @since 2021/6/12
 */
public class AC_3661 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        while (count-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] array = new int[n];
            for (int i = 0; i < n; i++) {
                array[i] = sc.nextInt();
            }
            System.out.println(cal(array, k));
        }
    }

    private static int cal(int[] array, int k) {
        int N = array.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i <= 100; i++) {
            int sum = 0;
            int j = 0;
            while (j < N) {
                if (array[j] != i) {
                    j += k;
                    sum++;
                } else {
                    j++;
                }
            }
            ans = Math.min(ans, sum);
        }
        return ans;
    }


}
