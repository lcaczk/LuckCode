package com.wkk.acwing.everyday;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/7/23
 */
public class 砖块 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while (T-- > 0) {
            int n = Integer.parseInt(sc.nextLine());
            String str = sc.nextLine();
            char[] chs = str.toCharArray();
            check(chs, n);
        }
    }

    private static void check(char[] chs, int n) {
        List<Integer> res1 = new ArrayList<>();
        List<Integer> res2 = new ArrayList<>();

        int ans1 = 0;
        int ans2 = 0;
        //    chs 假设目标为全黑
        // nextCh 假设目标为全白
        char[] nextCh = Arrays.copyOf(chs, n);
        for (int i = 0; i < n - 1; i++) {
            if (chs[i] == 'W') {
                chs[i] = 'B';
                chs[i + 1] = chs[i + 1] == 'B' ? 'W' : 'B';
                res1.add(i + 1);
                ans1++;
            }

            if (nextCh[i] == 'B') {
                nextCh[i] = 'W';
                nextCh[i + 1] = nextCh[i + 1] == 'W' ? 'B' : 'W';
                res2.add(i + 1);
                ans2++;
            }
        }
        // 输出格式
        // 第一行 次数。
        // 第二行 操作数字
        if (chs[n - 1] != 'B' && nextCh[n - 1] != 'W') {
            System.out.println(-1);
        } else if (chs[n - 1] == 'B') {
            System.out.println(ans1);
            if (ans1 != 0) {
                StringBuilder sb = new StringBuilder();
                for (Integer integer : res1) {
                    sb.append(integer);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }
        } else if (nextCh[n - 1] == 'W') {
            System.out.println(ans2);
            if (ans2 != 0) {
                StringBuilder sb = new StringBuilder();
                for (Integer integer : res2) {
                    sb.append(integer);
                    sb.append(" ");
                }
                sb.deleteCharAt(sb.length() - 1);
                System.out.println(sb.toString());
            }
        }
    }
}