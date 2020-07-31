package com.wkk.array;

/**
 * @author kongwiki@163.com
 * @since 2020/7/30下午8:57
 */
public class JumpGameII {
    public int jump(int[] nums) {
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 1, 1};
    }
}
