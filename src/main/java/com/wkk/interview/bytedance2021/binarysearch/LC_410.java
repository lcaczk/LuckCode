package com.wkk.interview.bytedance2021.binarysearch;

/**
 * 410. 分割数组的最大值
 * @author weikunkun
 * @since 2021/4/17
 */
public class LC_410 {
    public int splitArray(int[] nums, int m) {
        // 思路
        // 二分法
        // 理解： 最大值的最小值  > 所有元素里面大的 maxNum。  < 小于所有元素的总和 totalSum
        // 使用二分法，先从 (maxNum + totalSum) / 2 开始寻找 （每大于等于中间值 分割数量+1）
        // 如果分割的数量 > m 说明 不符合要求，分割的数量太多了
        //  提高 mid的值，这样减    少分割量
        //
        // 如果设置「数组各自和的最大值」很大，那么必然导致分割数很小；
        // 如果设置「数组各自和的最大值」很小，那么必然导致分割数很大。
        //
        int maxNum = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            sum += num;
        }
        int left = maxNum;
        int rigth = sum;
        while (left < rigth) {
            int mid = (left + rigth) / 2;
            if (check(nums, mid) > m) {
                left = mid + 1;
            } else {
                rigth = mid;
            }
        }
        return left;
    }

    private int check(int[] arrays, int targetNum) {
        int split = 1;
        int curSum = 0;
        for (int num : arrays) {
            // 尝试加上当前遍历的这个数，如果加上去超过了「子数组各自的和的最大值」，就不加这个数，另起炉灶
            if (curSum + num > targetNum) {
                split++;
                curSum = 0;
            }
            curSum += num;
        }
        return split;
    }
}
