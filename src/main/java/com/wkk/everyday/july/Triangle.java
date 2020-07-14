package com.wkk.everyday.july;

import javax.lang.model.type.ArrayType;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 2020/7/14上午10:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Triangle {
    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        // 边界值的确定
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }

        for (int i = m - 2; i >= 0; i--) {
            List<Integer> cur = triangle.get(i);
            for (int j = 0; j < cur.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + cur.get(j);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> a = new ArrayList<>();
        a.add(2);
        list.add(a);
        a = new ArrayList<>();
        a.add(3);
        a.add(4);
        list.add(a);
        a = new ArrayList<>();
        a.add(6);
        a.add(5);
        a.add(7);
        list.add(a);
        a = new ArrayList<>();
        a.add(4);
        a.add(1);
        a.add(8);
        a.add(3);
        list.add(a);
        System.out.println(list);
        minimumTotal(list);

    }
}
