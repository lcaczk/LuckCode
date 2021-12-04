package com.wkk.dfs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/2
 */
public class LC_523 {
    /**
     * 对固定数组的操作 求一个区间结果
     * 前缀数组
     * 不过基础的超出时间闲置
     *
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySum(int[] nums, int k) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        for (int i = 0; i <= N - 2; i++) {
            int j = i + 2;
            while (j <= N) {
                int num = preSum[j] - preSum[i];
                if (num % k == 0) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    /**
     * 优化I
     * 使用map
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumI(int[] nums, int k) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = nums[i-1] + preSum[i-1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            int curMod = preSum[i] % k;
            if (map.containsKey(curMod)) {
                int preIdx = map.get(curMod);
                if (i - preIdx >= 2) {
                    return true;
                }
            } else {
                map.put(curMod, i);
            }
        }
        return false;
    }


    /**
     * 前缀和优化II
     * 使用set
     * @param nums
     * @param k
     * @return
     */
    public boolean checkSubarraySumII(int[] nums, int k) {
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            preSum[i] = nums[i - 1] + preSum[i - 1];
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= N; i++) {
            set.add(preSum[i - 2] % k);
            if (set.contains(preSum[i] % k)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LC_523 lc_523 = new LC_523();
        int[] array = {23, 2, 4, 6, 6};
        int k = 7;
        lc_523.checkSubarraySumI(array, k);
    }
}
