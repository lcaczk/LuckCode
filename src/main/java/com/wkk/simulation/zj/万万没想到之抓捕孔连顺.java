package com.wkk.simulation.zj;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/16
 */
public class 万万没想到之抓捕孔连顺 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int d = sc.nextInt();
            int[] position = new int[n];
            sc.nextLine();
            for (int i = 0; i < n; i++) {
                position[i] = sc.nextInt();
            }
            run(n, d, position);
        }
    }

    private static void run(int n, int d, int[] position) {
        long sum = 0L;
        long mod = 99997867;
        for (int i = 0, j = 0; i < n; i++) {
            //从第三个开始判断，判断是否违法，如果违法j++
            while (i >= 2 && position[i] - position[j] > d) {
                j++;
            }
            //计算合法的次数,n(n-i)/2
            sum += (long) (i - j) * (long) (i - j - 1) / 2;
        }
        System.out.println(sum % mod);
    }
}
