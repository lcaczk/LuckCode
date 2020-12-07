package com.sh.greedy;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：659.分割数组为连续子序列
 * 题目链接：https://leetcode-cn.com/problems/split-array-into-consecutive-subsequences/
 * <p>
 * 题目描述：
 * 给你一个按升序排序的整数数组 num（可能包含重复数字），请你将它们分割成一个或多个长度至少为 3 的子序列，其中每个子序列都由连续整数组成。
 * 如果可以完成上述分割，则返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * 输入: [1,2,3,3,4,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3
 * 3, 4, 5
 * 示例 2：
 * 输入: [1,2,3,3,4,4,5,5]
 * 输出: True
 * 解释:
 * 你可以分割出这样两个连续子序列 :
 * 1, 2, 3, 4, 5
 * 3, 4, 5
 * 示例 3：
 * 输入: [1,2,3,4,4,5]
 * 输出: False
 * <p>
 * 提示：
 * 1 <= nums.length <= 10000
 * <p>
 * Related Topics 堆 贪心算法
 */
class L0659SplitArrayIntoConsecutiveSubsequences {
    public boolean isPossible(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        Map<Integer, Integer> endMap = new HashMap<>();
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }
        for (int x : nums) {
            int count = countMap.getOrDefault(x, 0);
            if (count > 0) {
                int preEndCount = endMap.getOrDefault(x - 1, 0);
                if (preEndCount > 0) {
                    countMap.put(x, count - 1);
                    endMap.put(x - 1, preEndCount - 1);
                    endMap.put(x, endMap.getOrDefault(x, 0) + 1);
                } else {
                    int nextEndCount1 = countMap.getOrDefault(x + 1, 0);
                    int nextEndCount2 = countMap.getOrDefault(x + 2, 0);
                    if (nextEndCount1 > 0 && nextEndCount2 > 0) {
                        countMap.put(x, count - 1);
                        countMap.put(x + 1, nextEndCount1 - 1);
                        countMap.put(x + 2, nextEndCount2 - 1);
                        endMap.put(x + 2, endMap.getOrDefault(x + 2, 0) + 1);
                    } else {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        L0659SplitArrayIntoConsecutiveSubsequences solution = new L0659SplitArrayIntoConsecutiveSubsequences();
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5}));
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 4, 4, 5}));
        System.out.println(solution.isPossible(new int[]{1, 2, 3, 3, 4, 4, 5, 5}));
    }
}
