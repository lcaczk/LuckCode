package com.wkk.interview.bytedance2020;

import java.util.Arrays;

/**
 * @Time: 2020/7/19上午9:34
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Easy_Square {
    public static int findElements(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] *= nums[i];
        }
        Arrays.sort(nums);
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] elements = {-1, 1, 2, 3, 6, 7, -7};
        int elements1 = findElements(elements);
        System.out.println(elements1);
        System.out.println(-7%3);
        System.out.println();

    }
}
