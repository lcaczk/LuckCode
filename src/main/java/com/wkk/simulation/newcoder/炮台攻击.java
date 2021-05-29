package com.wkk.simulation.newcoder;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/5/25
 */
public class 炮台攻击 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] enemy = new int[2];
        int[][] matrix = new int[3][2];
        int distance = 0;
        while (sc.hasNextInt()) {
            distance = sc.nextInt();
            for (int i = 0; i < 3; i++) {
                matrix[i][0] = sc.nextInt();
                matrix[i][1] = sc.nextInt();
            }
            enemy[0] = sc.nextInt();
            enemy[1] = sc.nextInt();
            int ans = 0;
            for (int[] tmp : matrix) {
                int a = (tmp[0] - enemy[0]) * (tmp[0] - enemy[0]);
                int b = (tmp[1] - enemy[1]) * (tmp[1] - enemy[1]);
                int c = (int) Math.sqrt(a + b);
                if (c < distance) {
                    ans++;
                }
            }
            System.out.println(ans + "x");
        }
    }
}
