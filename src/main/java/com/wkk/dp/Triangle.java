package com.wkk.dp;

import java.util.List;

/**
 * @Time: 2020/6/9下午11:19
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 特判
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }

        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];


        for(int i = triangle.size()-1; i>=0; i--){
            List<Integer> rows = triangle.get(i);
            for(int j = 0; j<rows.size(); j++){
                dp[i][j] = Math.min(dp[i+1][j], dp[i+1][j+1])+rows.get(j);
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][] dp = new int[3][3];
        dp[1][2] = 1;
//        List<List<Integer>> matrix = new ArrayList<>(4);
//        List<Integer> list = matrix.get(0);
//        list.add(2);
//        list = matrix.get(1);
//        list.add(3);
//        list.add(4);
//        list = matrix.get(2);
//        list.add(6);
//        list.add(5);
//        list.add(7);
//        list = matrix.get(3);
//        list.add(4);
//        list.add(1);
//        list.add(8);
//        list.add(2);
//        Triangle triangle = new Triangle();
//        int i = triangle.minimumTotal(matrix);
//        System.out.println(i);

    }

}
