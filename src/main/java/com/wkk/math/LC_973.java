package com.wkk.math;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author weikunkun
 * @since 2021/6/24
 */
public class LC_973 {
    public int[][] kClosest(int[][] points, int k) {
        // 思路
        // 按照欧几里得距离排序
        // 使用TreeMap 维护距离+点
        Map<Double, List<int[]>> map = new TreeMap<>();
        for (int[] point : points) {
            double dis = genODistance(point);
            map.computeIfAbsent(dis, list -> new ArrayList<>()).add(point);
        }
        List<int[]> tAns = new ArrayList<>();
        int i = 0;
        for (Double key : map.keySet()) {
            List<int[]> tmp = map.get(key);
            int size = tmp.size();
            i += size;
            if (i > k) {
                break;
            }
            tAns.addAll(tmp);
        }
        int[][] ans = new int[tAns.size()][2];
        for (int j = 0; j < tAns.size(); j++) {
            ans[j] = tAns.get(j);
        }
        return ans;
    }

    private double genODistance(int[] points) {
        return Math.sqrt(points[0] * points[0] + points[1] * points[1]);
    }

    public static void main(String[] args) {
        LC_973 lc_973 = new LC_973();
        int[][] points = {{1, 3}, {-2, 2}};
        int[][] ints = lc_973.kClosest(points, 1);
        for (int[] anInt : ints) {
            System.out.println(anInt[0] + "  " + anInt[1]);
        }
    }
}
