package com.wkk.bytedance2021.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 15 三数之和
 *
 * @author weikunkun
 * @since 2021/3/13
 */
public class LC_15 {
    /**
     * 思路
     * 双指针问题
     * 当前元素确定好之后，对剩余的两个元素通过双指针确定
     * 考虑内容：
     * 1. 考虑重复元素
     * 1.1 当前元素等于前一个元素
     * 直接下一个  避免 res[0]重复
     * 1.2 当获取结果时 left 和 right 也要移动 （需要跳出循环）
     * 移动时 防止 nums[left+1] = nums[left] 这样 res[1] ｜ res[2] 也会重复
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> treeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (Objects.isNull(nums) || nums.length == 0) {
            return result;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int temp = nums[i];
            if (i > 0 && temp == nums[i - 1]) {
                continue;
            }
            int rest = -temp;
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] > rest) {
                    right--;
                } else if (nums[left] + nums[right] < rest) {
                    left++;
                } else {
                    result.add(Arrays.asList(temp, nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right--]) {
                        right--;
                    }
                    left++;
                    right--;
                }
            }

        }

        return result;

    }
}
