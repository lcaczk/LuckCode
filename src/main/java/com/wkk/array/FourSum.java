package com.wkk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-3-12下午4:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FourSum {
    private static int len = 0;

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        len = nums.length;
        Arrays.sort(nums);
        return kSum(nums, target, 4, 0);
    }

    private static List<List<Integer>> kSum(int[] nums, int target, int k, int start) {
        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
        if (start >= len) {
            return res;
        }
        if (k == 2) {
            int i = start, j = len - 1;
            while (i < j) {
                if (target - nums[i] == nums[j]) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(target - nums[i]);
                    res.add(temp);
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j - 1] == nums[j]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (target - nums[i] > nums[j]) {
                    i++;
                } else {
                    j--;
                }
            }
        }else{
            for (int i = 0; i < len - (k - 1); i++) {
                if(i>start && nums[i] == nums[i-1]){
                    continue;
                }
                List<List<Integer>> lists = kSum(nums, target - nums[i], k - 1, i + 1);
                for (List<Integer> list : lists) {
                    list.add(0, nums[i]);
                }
                res.addAll(lists);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> lists = fourSum(nums, target);
        System.out.println(lists);
    }
}
