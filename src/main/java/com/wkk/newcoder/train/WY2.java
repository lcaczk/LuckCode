package com.wkk.newcoder.train;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 路灯
 * @author weikunkun
 * @since 2021/4/29
 */
public class WY2 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int[] pos;

        while ((line = reader.readLine()) != null) {
            String[] temp = line.split(" ");
            int n = Integer.parseInt(temp[0]);
            int l = Integer.parseInt(temp[1]);

            line = reader.readLine();
            temp = line.split(" ");
            pos = new int[n];
            for (int i = 0; i < n; i++) {
                pos[i] = Integer.parseInt(temp[i]);
            }

            Arrays.sort(pos);
            double maxDiff = Math.max(pos[0], l - pos[n-1]);
            for (int i = 1; i < n; i++) {
                double gap = (pos[i] - pos[i-1]) / 2.0;
                maxDiff = Math.max(gap, maxDiff);
            }

            // double ans = max_gap / 2.0;
            System.out.println(String.format("%.2f", maxDiff));
        }
    }
}
