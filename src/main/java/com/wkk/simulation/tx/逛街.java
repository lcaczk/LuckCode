package com.wkk.simulation.tx;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/2
 */
public class 逛街 {
    public static int[] findBuilding(int[] heights) {
        // write code here
        int n = heights.length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cur = count(heights, i, n);
            list.add(cur);
        }
        return list.stream().mapToInt(i -> i).toArray();

    }

    private static int count(int[] arr, int cur, int n) {
        int left = cur;
        int right = cur;
        int sum = 0;
        for (int i = 0; i < left; i++) {
            if (cur > arr[i]) {
                sum += 1;
            }
        }

        for (int i = n - 1; i > right; i--) {
            if (cur > arr[i]) {
                sum += 1;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] list = {5, 3, 8, 3, 2, 5};
        findBuilding(list);
    }
}
