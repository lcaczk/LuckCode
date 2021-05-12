package com.wkk.bitoperation;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/5/12
 */
public class LC_1310 {
    public int[] xorQueries(int[] arr, int[][] queries) {
        List<Integer> list = new ArrayList<>();
        for (int[] temp : queries) {
            int first = 0;
            for (int i = temp[0]; i <= temp[1]; i++) {
                first ^= arr[i];
            }
            list.add(first);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
