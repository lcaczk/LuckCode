package com.wkk.simulation.zj;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 水仙花数 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String tmp = sc.nextLine();
            String[] strs = tmp.split(" ");
            int left = Integer.parseInt(strs[0]);
            int right = Integer.parseInt(strs[1]);
            cal(left, right);
        }
    }

    private static void cal(int left, int right) {
        List<Integer> res = new ArrayList<>();
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isNum(i)) {
                count++;
                System.out.print(i + " ");
            }
        }
        if (count == 0) {
            System.out.println("no");
        } else {
            System.out.println();
        }
    }

    private static boolean isNum(int num) {
        int sum = 0;
        int pow = 3;
        int target = num;
        while (num != 0) {
            int pop = num % 10;
            sum += (int)Math.pow(pop, pow);
            num /= 10;
        }
        return target == sum;
    }
}
