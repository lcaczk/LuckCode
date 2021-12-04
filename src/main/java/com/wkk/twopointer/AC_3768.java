package com.wkk.twopointer;

import java.util.Scanner;

/**
 * 字符串删减
 *
 * @author weikunkun
 * @since 2021/7/15
 */
public class AC_3768 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        char[] chs = str.toCharArray();
        int sum = 0;
        int i = 0;
        int j = 0;
        int diff;
        while (i < n) {
            if (chs[i] == 'x') { // 统计一段x
                i++;
            } else { //
                diff = i - j;
                if (diff >= 3) {
                    sum += (diff - 2);
                }
                i++;
                j = i;
            }
        }
        diff = i - j;
        if (diff >= 3) {
            sum += (diff - 2);
        }
        System.out.println(sum);
    }

    private static int genLen(char[] chs, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (chs[i] != 'x') {
                continue;
            }
            int j = i + 1;
            while (j < n && chs[j] == 'x') {
                j++;
            }
            sum += Math.max(0, j - i - 2);
            i = j;
        }
        return sum;
    }
}
