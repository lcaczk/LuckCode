package com.wkk.simulation.mt;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/5
 */
public class 公司管理 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int[] arr = new int[n];
            boolean flag = true;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
                sum += arr[i];
                if (arr[i] == 2) {
                    flag = false;
                }
            }
            if (!flag) {
                System.out.println("NO");
                continue;
            }
            sum -= n;
            if (sum == n - 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
