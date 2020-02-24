package com.wkk.array;

/**
 * @Time: 20-2-23下午5:39
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MoveZeroes {
    public static void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[j] = nums[i];
                if (i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }

    public static void moveZeroesII(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int insertPos = 0;
        for (int num : nums) {
            if (num != 0) {
                nums[insertPos++] = num;
            }
        }

        while (insertPos < nums.length) {
            nums[insertPos++] = 0;
        }

    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        MoveZeroes.moveZeroes(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
