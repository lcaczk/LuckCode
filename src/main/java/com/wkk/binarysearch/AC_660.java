package com.wkk.binarysearch;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/4/26
 */
public class AC_660 {
    private static int targetNums;
    public static void main(String[] args) {
        // 思路
        // 直接正向思维：在N根绳子中切成M根等长的绳子，求M根绳子最长的长度是多少
        // 逆向思维：不断假设最后切出来的绳子长度为x，然后需要达到M根数量，并且最大即可
        // 二分查找 x 的范围 (0, maxLen)
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        targetNums = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        double right = 0;
        for (int num : array) {
            right = Math.max(right, num);
        }
        double left = 0;
        // 因为是浮点数，所以只能靠每次循环获取的mid来缩小范围
        while (right - left > 1e-4) {
            double mid = (left + right) / 2;
            if (helper(array, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        System.out.printf("%.2f\n",left);

    }

    private static boolean helper(int[] array, double maxLen) {
        int split = 0;
        for (int num : array) {
            split += num / maxLen;
        }
        return split >= targetNums;
    }
}
