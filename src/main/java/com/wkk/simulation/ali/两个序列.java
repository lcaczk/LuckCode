package com.wkk.simulation.ali;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @author weikunkun
 * @since 2021/6/23
 */
public class 两个序列 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String str = bf.readLine();
        int n = Integer.parseInt(str);
        for (int i = 0; i < n; i++) {
            String str1 = bf.readLine();
            int m = Integer.parseInt(str1);
            String[] str2 = bf.readLine().split(" ");
            String[] str3 = bf.readLine().split(" ");
            int[][] items = new int[m][2];
            for (int j = 0; j < m; j++) {
                items[j] = new int[]{Integer.parseInt(str2[j]), Integer.parseInt(str3[j])};
            }

            //对数组排序
            Arrays.sort(items, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
            //dp数组保存的是至今这个下标位置，最大的非连续递增序列的长度。
            int res = 0;
            int[] dp = new int[m];
            for (int j = 0; j < m; j++) {
                dp[j] = 1;
                for (int l = 0; l < j; l++) {
                    if (items[l][0] < items[j][0] && items[l][1] < items[j][1]) dp[j] = Math.max(dp[j], dp[l] + 1);
                }
                res = Math.max(dp[j], res);
            }
            System.out.println(res);
        }
    }

    private static Comparator<int[]> comparator = new Comparator<int[]>() {
        @Override
        public int compare(int[] o1, int[] o2) {
            if (o1[0] > o2[0]) return 1;
            else if (o1[0] < o2[0]) return -1;
            else {
                if (o1[1] > o2[1]) return -1;
                else if (o1[1] == o2[1]) return 0;
                else return 1;
            }
        }
    };
}
