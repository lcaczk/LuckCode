package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/7/12
 */
public class LC_34 {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int n = nums.length;
        int[] ans = new int[2];
        ans[0] = findSmall(nums, target, n);
        ans[1] = findLarge(nums, target, n);
        return ans;
    }

    private static int findSmall(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r >> 1;
            if (nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }

    private static int findLarge(int[] nums, int target, int n) {
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return nums[l] == target ? l : -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        searchRange(arr, 2);
    }
}
