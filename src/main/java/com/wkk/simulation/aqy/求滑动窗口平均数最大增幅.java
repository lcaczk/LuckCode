package com.wkk.simulation.aqy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/1
 */
public class 求滑动窗口平均数最大增幅 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] split = s.split(",");
        int n = split.length;
        List<Integer> list = new ArrayList<>();
        int k = Integer.parseInt(split[n - 1].split(":")[1]);
        int last = Integer.parseInt(split[n - 1].split(":")[0]);
        for (int i = 0; i < n - 1; i++) {
            list.add(Integer.parseInt(split[i]));
        }
        list.add(last);
        int[] array = list.stream().mapToInt(i -> i).toArray();
        cal(array, array.length, k);
    }

    private static double genH(long pre, long cur) {
        return (cur - pre) / (double) pre;
    }

    private static void cal(int[] arr, int n, int k) {
        int i = 0;
        int j = i + k - 1;
        double max = Double.MIN_VALUE;
        long pre = 0;
        while (j < n) {
            long cur = genSum(arr, i, j);
            if (i == 0) {
                pre = cur;
                i++;
                j++;
                continue;
            }
            double v = genH(pre, cur);
            max = Math.max(max, v);
            pre = cur;
            i++;
            j++;
        }
        double ans = max * 100;
        BigDecimal decimal = new BigDecimal(ans);
        String s = decimal.setScale(2, BigDecimal.ROUND_HALF_UP).toString();
        s += "%";
        System.out.println(s);
    }


    private static long genSum(int[] arr, int i, int j) {
        long sum = 0;
        for (int k = i; k <= j; k++) {
            sum += arr[k];
        }
        return sum;
    }
}
