package com.wkk.bytedance2021.sort;

/**
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_179 {
    public String largestNumber(int[] nums) {
        if (null == nums || nums.length == 0) {
            return "";
        }
        // 思路： 重新定义大小的比较
        String[] arr = new String[nums.length];
        int i = 0;
        for (int num : nums) {
            arr[i++] = String.valueOf(num);
        }
        int left = 0;
        int right = nums.length - 1;
        StringBuilder res = new StringBuilder();
        quickSort(arr, left, right);
        for (String s : arr) {
            if (res.toString().equals("0")) res.delete(0, 1);
            res.append(s);
        }
        return res.toString();
    }

    private void quickSort(String[] nums, int left, int right) {
        if (left > right) {
            return;
        }
        int index = position(nums, left, right);
        quickSort(nums, left, index - 1);
        quickSort(nums, index + 1, right);
    }

    private int position(String[] nums, int left, int right) {
        String temp = nums[left];
        while (left < right) {
            while (left < right && (nums[right] + temp).compareTo(temp + nums[right]) <= 0) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && (nums[left] + temp).compareTo(temp + nums[left]) >= 0) {
                left++;
            }
            nums[right] = nums[left];
        }
        nums[left] = temp;
        return left;
    }
}
