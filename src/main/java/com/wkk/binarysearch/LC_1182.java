package com.wkk.binarysearch;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1182. 与目标颜色间的最短距离
 *
 * @author weikunkun
 * @since 2021/7/15
 */
public class LC_1182 {
    public static List<Integer> shortestDistanceColor(int[] colors, int[][] queries) {
        Map<Integer, List<Integer>> map = new HashMap<>(16);
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            map.computeIfAbsent(colors[i], list -> new ArrayList<>()).add(i);
        }
        List<Integer> list = new ArrayList<>();
        for (int[] querie : queries) {
            int idx = querie[0];
            int target = querie[1];
            if (!map.containsKey(target) || map.get(target).size() == 0) {
                list.add(-1);
                continue;
            }
            List<Integer> tmp = map.get(target);
            int[] arr = tmp.stream().mapToInt(i -> i).toArray();
            // 二分
            // 在arr范围内的两边
            int tarIdx = binarySearch(arr, idx);
            list.add(Math.abs(tarIdx - idx));
        }
        return list;
    }

    private static int binarySearch(int[] arr, int x) {
        int n = arr.length;
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + j + 1 >> 1;
            if (Math.abs(arr[i] - x) < Math.abs(arr[j] - x)) {
                j = mid;
            } else {
                i = mid;
            }
        }
        return arr[i];
    }

    public static void main(String[] args) {
        int[] colors = {3, 1, 1, 2, 3, 3, 2, 1, 2, 3, 1, 1, 3, 2, 3, 1, 1, 1, 1, 2, 2, 1, 2, 2, 2, 1, 1, 1, 1, 2, 3, 3, 3, 1, 3, 2, 1, 1, 2, 2, 1, 3, 1, 2, 1, 1, 2, 2, 1, 2};
        int[][] queries = {{28, 1}, {47, 2}};
        // 输出
        // [2,1,0,0,1,7,0,0,1,1,1,2,8,1,0,2,1,1,4,2,2,1,1,0,2,0,1,1,3,4,0,1,0,2,3,3,4,3,1,1,1,3,0,1,0,0,0,1,8,0]
        // 正常
        // [2,1,0,0,1,7,0,0,1,0,0,2,8,1,0,2,1,0,2,2,2,0,1,0,2,0,0,1,3,2,0,1,0,2,3,2,2,3,1,1,1,1,0,1,0,0,0,0,8,0]
        System.out.println(shortestDistanceColor(colors, queries));
    }
}
