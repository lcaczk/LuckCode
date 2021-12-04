package com.wkk.greedy;

import java.util.ArrayList;
import java.util.List;

/**
 * 986. 区间列表的交集
 *
 * @author weikunkun
 * @since 2021/7/19
 */
public class LC_986 {
    public static int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        List<int[]> list = new ArrayList<>();
        int m = firstList.length;
        int n = secondList.length;
        int i = 0;
        int j = 0;
        int[] first;
        int[] second;
        int innerFL;
        int innerFR;
        int innerSL;
        int innerSR;
        int innerL;
        int innerR;
        while (i < m && j < n) {
            first = firstList[i];
            second = secondList[j];
            innerFL = first[0];
            innerFR = first[1];
            innerSL = second[0];
            innerSR = second[1];
            if (innerFL < innerSL) {
                innerL = innerSL;
            } else {
                innerL = innerFL;
            }

            if (innerFR < innerSR) {
                innerR = innerFR;
                i++;
            } else {
                innerR = innerSR;
                j++;
            }
            if (innerL <= innerR) {
                list.add(new int[]{innerL, innerR});
            }

        }
        int[][] ans = new int[list.size()][2];
        int k = 0;
        for (int[] tmp : list) {
            ans[k++] = tmp;
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] first = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int[][] second = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        int[][] ints = intervalIntersection(first, second);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + " " + anInt[1]);
        }
    }
}
