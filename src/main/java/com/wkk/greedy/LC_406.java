package com.wkk.greedy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 根据身高重建队列
 * @author weikunkun
 * @since 2021/7/6
 */
public class LC_406 {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (x, y) -> (x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]));
        List<int[]> list = new ArrayList<>();
        for (int[] person : people) {
            list.add(person[1], person);
        }
        return list.toArray(new int[list.size()][2]);
    }
}
