package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/4/26
 */
public class LC_1011 {
    public int shipWithinDays(int[] weights, int D) {
        // 思路 二分查找
        // 然后进行划分
        int sum = 0;
        int maxNum = 0;
        for (int weight : weights) {
            sum += weight;
            maxNum = Math.max(weight, maxNum);
        }
        int left = maxNum;
        int right = sum;
        while (left < right) {
            int mid = (left + right) / 2;
            if (help(weights, mid) > D) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    /**
     * 用于记录值为 mid 时能够划分的数组个数
     * 划分数量大于D，说明可以将mid再调高一些
     */
    private int help(int[] weights, int maxNum) {
        int split = 1;
        int sum = 0;
        for (int weight : weights) {
            if (sum + weight > maxNum) {
                split++;
                sum = 0;
            }
            sum += weight;
        }
        return split;
    }

    public static void main(String[] args) {
        com.wkk.everyday.two1.april.LC_1011 lc_1011 = new com.wkk.everyday.two1.april.LC_1011();
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        int D = 5;
        lc_1011.shipWithinDays(array, D);
        double right = 0;
        for (int num : array) {
            right = Math.max(right, num);
        }
    }
}
