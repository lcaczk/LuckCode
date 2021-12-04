package com.wkk.array;

/**
 * @author weikunkun
 * @since 2021/7/4
 */
public class LC_645 {
    public int[] findErrorNums(int[] nums) {
        // 桶排序
        // 找出
        int n = nums.length;
        int[] ans = new int[2];
        for (int i = 0; i < n; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }

        }
        for (int i = 0; i < n; i++) {
            System.out.print(nums[i] + " ");
        }
        for (int i = 0; i < n; i++) {
            if (i + 1 != nums[i]) {
                ans[0] = i;
                ans[1] = i + 1;
            }
        }
        return ans;
    }
    // [1,5,3,2,2,7,6,4,8,9]
    private void swap(int[] nums, int i, int j) {
        int a = nums[i];
        nums[i] = nums[j];
        nums[j] = a;
    }

    public static void main(String[] args) {
        LC_645 lc = new LC_645();
        int[] ar = {1,5,3,2,2,7,6,4,8,9};
        lc.findErrorNums(ar);
    }
}
