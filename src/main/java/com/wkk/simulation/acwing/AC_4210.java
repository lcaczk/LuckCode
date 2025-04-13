package com.wkk.simulation.acwing;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2022/1/15
 */
public class AC_4210 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int loopSize = n - 1;
        int sum = 0;
        for (int i = 2; i <= loopSize; i++) {
            int tmp = n;
            int cnt = 0;
            while (tmp != 0) {
                cnt += tmp % i;
                tmp /= i;
            }
            sum += cnt;
        }
        int gcd = gcd(sum, n - 2);
        sum = sum / gcd;
        int rst = (n - 2) / gcd;

        System.out.println(sum + "/" + rst);
    }

    private static int gcd(int first, int second) {
        while (second != 0) {
            int last = first % second;
            first = second;
            second = last;
        }
        return first;
    }
}
