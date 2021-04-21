package com.wkk.acwing.prefix;

import java.util.Scanner;

/**
 * 一维前缀和
 * @author weikunkun
 * @since 2021/4/21
 */
public class AC_795 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int count = sc.nextInt();
        int[] array = new int[len];
        for (int i = 0; i < len; i++) {
            array[i] = sc.nextInt();
        }
        // 构造前缀和
        int[] preFixArray = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            preFixArray[i] = array[i - 1] + preFixArray[i - 1];
        }
        while (count-- > 0) {
            int idx1 = sc.nextInt() - 1;
            int idx2 = sc.nextInt();
            System.out.println(preFixArray[idx2] - preFixArray[idx1]);
        }
    }
}
