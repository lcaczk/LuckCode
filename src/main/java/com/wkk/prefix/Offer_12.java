package com.wkk.prefix;

/**
 * @author weikunkun
 * @since 2021/8/11
 */
public class Offer_12 {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] pre = genPreSum(nums, n);
        int[] suf = genSufSum(nums, n);
        for (int i = 1; i <= n - 1; i++) {
            int pSum = pre[i];
            int next = n - i - 1;
            if (suf[next] == pSum) {
                return i;
            }
        }
        return -1;
    }

    private int[] genPreSum(int[] nums, int n) {
        int[] arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = nums[i - 1] + arr[i - 1];
        }
        return arr;
    }

    private int[] genSufSum(int[] nums, int n) {
        int[] arr = new int[n + 1];
        for (int i = n ; i >= 0; i--) {
            arr[i] = arr[i + 1] + nums[i + 1];
        }
        return arr;
    }

    public static void main(String[] args) {
        Offer_12 offer = new Offer_12();
        int[] arr = {1, 7, 3, 6, 5, 6};
        offer.pivotIndex(arr);
    }
}
