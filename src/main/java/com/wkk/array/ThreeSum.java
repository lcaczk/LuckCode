package com.wkk.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 20-2-24上午7:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        if (nums.length < 3) {
            return lists;
        }
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i-1])) {
                int sum = 0 - nums[i];
                int low = i + 1;
                int height = nums.length - 1;
                while (low < height) {
                    if (nums[low] + nums[height] == sum) {
                        lists.add(Arrays.asList(nums[i], nums[low], nums[height]));
                        while (low < height && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < height && nums[height] == nums[height - 1]) {
                            height--;
                        }
                        low++;
                        height--;
                    } else if ((nums[low] + nums[height] < sum)) {
                        low++;
                    } else {
                        height--;
                    }
                }
            }

        }
        return lists;
    }

    public static List<List<Integer>> threeSumII(int[] nums) {
        List<List<Integer>> lists = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    }
                }

            }

        }
        return lists;
    }

    public static void main(String[] args) {
//        int[] arrs = {-1, 0, 1, 2, -1, -4};
        int[] nums = {-1, 0, 1, 2, -1, 4};
        System.out.println(ThreeSum.threeSum(nums));
    }
}
