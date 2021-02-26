package com.offer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 题目：剑指 Offer 03.数组中重复的数字
 * 题目链接：https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 * 标签：数组 哈希表
 * <p>
 * 题目描述：
 * 找出数组中重复的数字。
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。
 * 请找出数组中任意一个重复的数字。
 * <p>
 * 示例 1：
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3
 * <p>
 * 限制：
 * 2 <= n <= 100000
 */
class Offer03 {
    /**
     * set 检验重复元素
     *
     * @param nums
     * @return
     */
    public int findRepeatNumber(int[] nums) {
        // 直接用set遍历查找
        Set<Integer> hashSet = new HashSet<>();
        for (int n : nums) {
            if (hashSet.contains(n)) {
                return n;
            }
            hashSet.add(n);
        }
        return 0;
    }

    /**
     * 排序之后 判断
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberII(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i + 1] == nums[i]) {
                return nums[i];
            }
        }
        return -1;
    }

    /**
     * 原地置换法
     *
     * @param nums
     * @return
     */
    public int findRepeatNumberIII(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                temp = nums[i];
                nums[i] = nums[nums[i]];
                nums[nums[i]] = temp;
            }
        }
        return -1;
    }
}
