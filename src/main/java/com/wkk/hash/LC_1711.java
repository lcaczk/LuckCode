package com.wkk.hash;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/7/7
 */
public class LC_1711 {
    private static int mod = 1000000007;

    public static int countPairs(int[] deliciousness) {
        // 2数之和
        int max = Arrays.stream(deliciousness).max().getAsInt() * 2;
        Map<Integer, Integer> map = new HashMap<>(1000);
        for (int num : deliciousness) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int ans = 0;
        for (int num : deliciousness) {
            // 从 1 ～ maxVal 所有的2的幂次
            for (int i = 1; i <= max; i <<= 1) {
                if (isTwo(i - num)) {
                    ans = (ans + map.getOrDefault(i - num, 0)) % mod;
                }
            }
        }
        return ans;
    }

    private static boolean isTwo(int num) {
        if (num < 0) {
            return false;
        }
        return (num & (num - 1)) == 0;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9};
        countPairs(arr);
    }
}
