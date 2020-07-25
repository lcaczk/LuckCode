package com.wkk.everyday.june;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 2020/6/12上午9:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreeSum {
    // 暴力回溯 (超时)
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        int length = 3;
        backtrack(0, res, out, length, nums, 0);
        return res;
    }

    private void backtrack(int start, List<List<Integer>> res, List<Integer> out, int len, int[] nums, int target) {
        if (out.size() == len && target == 0) {
            res.add(new ArrayList<>(out));
        }
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            out.add(nums[i]);
            backtrack(i + 1, res, out, len, nums, target - nums[i]);
            out.remove(out.size() - 1);
        }
    }

    public List<List<Integer>> threeSumII(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3) {
            return res;
        }
        for (int i = 0; i < nums.length-2; i++) {
            // 去除i之前的重复元素
            if (i == 0 || nums[i] != nums[i - 1]) {
                int cur = nums[i];
                int sum = -cur;
                int low = i + 1;
                int height = nums.length - 1;
                while (low < height) {
                    if (nums[low] + nums[height] == sum) {
                        res.add(Arrays.asList(cur, nums[low], nums[height]));
                        // 去除之后的重复元素 (左右指针当前的重复元素都要去除)
                        while (low < height && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < height && nums[height] == nums[height - 1]) {
                            height--;
                        }
                        low++;
                        height--;
                    } else if (nums[low] + nums[height] < sum) {
                        low++;
                    } else {
                        height--;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, 4};
        ThreeSum threeSum = new ThreeSum();
        List<List<Integer>> lists = threeSum.threeSumII(nums);
        for (List<Integer> list : lists) {
            System.out.println(list);
        }

    }
}
