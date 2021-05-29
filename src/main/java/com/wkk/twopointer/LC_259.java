package com.wkk.twopointer;

import java.util.Arrays;

/**
 * 259. 较小的三数之和
 * 思路不同，但是核心解法也是头尾指针
 * 因为只求出 < target的结果
 * 所以所以对于数量的统计 需要注意
 * @author weikunkun
 * @since 2021/5/26
 */
public class LC_259 {
    public int threeSumSmaller(int[] nums, int target) {
        Arrays.sort(nums);
        int N = nums.length;
        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            int left = i + 1;
            int right = N - 1;
            while (left < right) {
                int innerCur = nums[i] + nums[left] + nums[right];
                if (innerCur < target) {
                    int innerCount = right - left;
                    count += innerCount;
                    left++;
                } else {
                    right--;
                }
            }
        }
        return count;
    }
}
