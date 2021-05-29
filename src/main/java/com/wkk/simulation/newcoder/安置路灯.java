package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * 模拟问题
 * 贪心 + 指针
 * @author weikunkun
 * @since 2021/5/27
 */
public class 安置路灯 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int counts = sc.nextInt();
        while (counts-- > 0) {
            int len = sc.nextInt();
            String line = sc.next();
            char[] array = line.toCharArray();
            int ans = cal(array);
            System.out.println(ans);
        }
    }

    // 1. 设置遍历指针
    // 2. 如果array[i] == '.'
    //    在i+1的位置放置灯，能得到当前最优结果 同时i后移三位
    // 3. 如果array[i] == 'X'
    //    不做任何处理
    private static int cal(char[] array) {
        int sum = 0;
        int N = array.length;
        int i = 0;
        while (i < N) {
            if (array[i] == '.') {
                sum += 1;
                i += 3;
            } else {
                i++;
            }
        }
        return sum;
    }
}
