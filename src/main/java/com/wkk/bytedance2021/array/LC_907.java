package com.wkk.bytedance2021.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/3/21
 */
public class LC_907 {
    public int sumSubarrayMins(int[] arr) {
        // 思路 for 循环 之后再将结果相加
        if (arr == null || arr.length == 0) {
            return 0;
        }
        List<Integer> out;
        List<List<Integer>> result = new ArrayList<>();
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            out = new ArrayList<>();
            int j = i;
            while (j < len) {
                out.add(arr[j]);
                result.add(new ArrayList<>(out));
                j++;
            }
        }
        return listToSum(result);

    }

    private int listToSum(List<List<Integer>> list) {
        int sum = 0;
        for (List<Integer> temp : list) {
            sum +=  temp.stream().mapToInt(v -> v).min().orElse(0);
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        LC_907 lc_xxx = new LC_907();
        lc_xxx.sumSubarrayMins(arr);

    }

    public static int getMi() {
        List<Integer> listOfIntegers = Arrays.asList(1, 2, 3, 4, 56, 7, 89, 10);

        // then
        int i = listOfIntegers
                .stream()
                .mapToInt(v -> v)
                .min().orElse(0);
        return i;
    }
}
