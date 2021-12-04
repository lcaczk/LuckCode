package com.wkk.dp.twosequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/16
 */
public class LC_120 {
    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        int rows = triangle.size();
        int cols;
        List<Integer> curList;
        List<Integer> preList = new ArrayList<>();
        List<Integer> ansList = new ArrayList<>();
        preList.add(triangle.get(0).get(0));
        for (int i = 1; i < rows; i++) {
            ansList = new ArrayList<>();
            curList = triangle.get(i);
            cols = curList.size();
            int len = preList.size();
            for (int j = 0; j < cols; j++) {
                int cur;
                if (j == 0) {
                    cur = curList.get(j) + preList.get(j);
                } else if (j == cols - 1) {
                    cur = curList.get(j) + preList.get(len - 1);
                } else {
                    cur = Math.max(preList.get(j - 1), preList.get(j)) + curList.get(j);
                }
                ansList.add(cur);
            }
            preList = ansList;
        }
        System.out.println(ansList);
        return preList.stream().max(Comparator.comparing(Integer::intValue)).get();
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> tmp = Arrays.asList(-10);
        triangle.add(tmp);

//        tmp = Arrays.asList(3, 4);
//        triangle.add(tmp);
//
//        tmp = Arrays.asList(6, 5, 7);
//        triangle.add(tmp);
//
//        tmp = Arrays.asList(4, 1, 8, 3);
//        triangle.add(tmp);

        minimumTotal(triangle);
    }
}
