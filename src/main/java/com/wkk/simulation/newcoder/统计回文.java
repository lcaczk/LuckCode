package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/4
 */
public class 统计回文 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String first = sc.nextLine();
            String second = sc.nextLine();
            int count = 0;
            for (int i = 0; i <= first.length(); i++) {
                StringBuilder sb = new StringBuilder(first);
                sb.insert(i, second);
                if (isSame(sb.toString())) {
                    count ++;
                }
            }
            System.out.println(count);
        }
    }

    private static boolean isSame(String str) {
        char[] arr = str.toCharArray();
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
