package com.wkk.interview.bytedance2020;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 2020/7/25上午10:00
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if (nums == null || n == 0) {
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0; i < n; i++) {
            // 前面去重
            if (i == 0 || nums[i] != nums[i - 1]) {
                int target = -nums[i];
                int low = i + 1;
                int high = n - 1;
                while (low < high) {
                    int sum = nums[low] + nums[high];
                    if (sum < target) {
                        low++;
                    } else if (sum > target) {
                        high--;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                }
            }
        }
        return res;
    }
}
