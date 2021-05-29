package com.wkk.dp.sequences;

import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author weikunkun
 * @since 2021/5/4
 */
public class LC_1696 {
    /**
     * 子序列模型问题，
     * 不过需要进行优化，因为直接暴力解决，会超时
     *
     * @param nums
     * @param k
     * @return
     */
    public static int maxResultII(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = nums[0];
        for (int i = 1; i < len; i++) {
            int j = k;
            while (j > 0) {
                int idx = i - j;
                while (idx >= 0) {
                    dp[i] = Math.max(dp[idx] + nums[i], dp[i]);
                }
                j--;
            }
        }
        return dp[len - 1];
    }

    /**
     * 超时的点在于 每次都要重新遍历前k个元素
     * 所以需要进行优化
     * 思路：每次遍历前k的元素的原因是寻找前k个元素里面的最值，然后得到结果
     * 所以可以引入大根堆，存储的数据为[dp[j], j]
     * 堆顶肯定是我们目前需要的最大元素
     * 每次放入的时候，也需要放入当前得到的最大值以及索引下标i
     * @param nums
     * @param k
     * @return
     */
    public int maxResult(int[] nums, int k) {
        // dp
        // 以i为结尾的最大得分
        int len = nums.length;
        Queue<int[]> queue = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        queue.offer(new int[]{nums[0], 0});
        int res = nums[0];
        for (int i = 1; i < len; i++) {
            while (i - queue.peek()[1] > k) {
                queue.poll();
            }
            res = queue.peek()[0] + nums[i];
            queue.offer(new int[]{res, i});
        }
        return res;
    }
}
