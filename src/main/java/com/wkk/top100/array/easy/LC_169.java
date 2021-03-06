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

    public int majorityElementII(int[] nums) {
        if (null == nums || nums.length == 0) {
            return -1;
        }
        int mid = nums.length / 2;
        int idx = position(nums, 0, nums.length-1);
        while (idx != mid) {
            if (idx < mid) {
                idx = position(nums, idx+1, nums.length-1);
            } else  {
                idx = position(nums, 0, idx-1);
            }
        }
        return nums[idx];
    }

    private int position (int[] nums, int left, int right) {
        int num = nums[left];
        while (left < right) {
            while (left < right && nums[right] >= num) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= num) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = num;
        return left;
    }

    /**
     * 摩根算法
     * @param nums
     * @return
     */
    public int majorityElementIII(int[] nums) {
        int x = 0, votes = 0;
        for(int num : nums){
            if(votes == 0) x = num;
            votes += num == x ? 1 : -1;
        }
        return x;
    }

    public static void main(String[] args) {
        int[] array = {1,1,1,2,3};
        LC_169 lc_169 = new LC_169();
        lc_169.majorityElementII(array);
        int[] newArray = new int[3];
        int[] ints = Arrays.copyOf(array, 3);
        System.arraycopy(array, 0, array, 0,
                3);
        System.out.println(array.length);
        for (int anInt : ints) {
            System.out.println(anInt);
        }

    }
}
