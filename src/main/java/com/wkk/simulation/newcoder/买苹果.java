package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/9
 */
public class 买苹果 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        System.out.println(cal(total));
    }

    private static int cal(int total) {
        int rst = total % 8;
        if (rst == 0) {
            return total / 8;
        } else if (rst % 6 == 0) {
            return rst / 6 + (total - rst) / 8;
        }
        int num8 = total / 8;
        int j = num8 - 1;
        while (j >= 0) {
            rst = (num8 - j) * 8 + rst;
            if (rst % 6 == 0) {
                return rst / 6 + (total - rst) / 8;
            }
            j--;

        }
        return -1;
    }
}
