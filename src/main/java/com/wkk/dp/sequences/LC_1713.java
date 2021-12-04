package com.wkk.dp.sequences;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/7/26
 */
public class LC_1713 {
    /**
     * 超时
     * @param target
     * @param arr
     * @return
     */
    public int minOperations(int[] target, int[] arr) {
        // key: num
        // value: idx
        Map<Integer, Integer> map = new HashMap<>();
        int n = target.length;
        int m = arr.length;
        for (int i = 0; i < n; i++) {
            map.put(target[i], i);
        }
        List<Integer> tmp = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (map.containsKey(arr[i])) {
                tmp.add(map.get(arr[i]));
            }
        }
        int[] idxArr = tmp.stream().mapToInt(i -> i).toArray();
        // print(idxArr);
        // 最长递增子序列
        int len = idxArr.length;
        if (len == 0) {
            return n;
        }
        int[] dp = new int[len];
        Arrays.fill(dp, 1);
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (idxArr[j] < idxArr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        //print(dp);
        //System.out.println(n);
        int max = Arrays.stream(dp).max().getAsInt();
        //System.out.println(max);
        return n - max;
    }

    private void print(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
