package com.wkk.top100.array.easy;

import java.util.Arrays;

/**
 * 多数元素
 * 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * @author weikunkun
 * @since 2021/2/6
 */
public class LC_169 {
    /**
     * 超过半数的元素，肯定包含了排序之后的数组的中间
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        // TODO 判空
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
