package com.wkk.prefix;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class LC_525 {
    /**
     * 最开始是前缀求和的方式错了
     * 后面是计算距离的方式错了
     * 最后是返回的结果，极端情况没有好好考虑
     * @param nums
     * @return
     */
    public static int findMaxLength(int[] nums) {
        // 暴力 肯定超时
        int N = nums.length;
        int[] preSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int preNum = 1;
            if (nums[i - 1] == 0) {
                preNum = -1;
            }
            preSum[i] = preSum[i - 1] + preNum;
        }
        int max = Integer.MIN_VALUE;
        // map key: 前缀结果 value: 索引位置
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i <= N; i++) {
            if (map.containsKey(preSum[i])) {
                max = Math.max(max, i - map.get(preSum[i]));
            } else {
                map.put(preSum[i], i);
            }
        }
        return max == Integer.MIN_VALUE ? 0 : max;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1};
        findMaxLength(nums);
    }
}
