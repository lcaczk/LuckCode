package com.wkk.simulation.lc;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/12/26
 */
public class LC_5965 {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new LinkedHashMap<>();
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(arr[i], list-> new ArrayList<>()).add(i);
        }

        long[] res = new long[arr.length];
        int k = 0;
        for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
            List<Integer> list = entry.getValue();
            int[] array = list.stream().mapToInt(Integer::intValue).toArray();
            int innerLen = array.length;
            long sum = 0;
            for (int i = 0; i < innerLen; i++) {
                for (int j = 0; j < innerLen; j++) {
                    if (i == j) {
                        continue;
                    }
                    int diff = Math.abs(array[i] - array[j]);
                    sum += diff;
                }
            }
            res[k] = sum;
            k++;
        }
        return res;
    }
}
