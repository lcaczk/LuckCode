package com.wkk.simulation.acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/12
 */
public class AC_3660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        while (row-- > 0) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int left = sc.nextInt();
            int right = sc.nextInt();
            int[] a = {1, 1};
            int[] b = {1, cols};
            int[] c = {rows, 1};
            int[] d = {rows, cols};
            int dis = 0;
            List<int[]> tmp = new ArrayList<>();
            tmp.add(a);
            tmp.add(b);
            tmp.add(c);
            tmp.add(d);
            for (int[] arr : tmp) {
                dis = Math.max(dis, Math.abs(arr[0] - left) + Math.abs(arr[1] - right));
            }
            System.out.println(dis);
        }
    }
}
