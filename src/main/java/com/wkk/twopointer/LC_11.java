package com.wkk.twopointer;

/**
 * 盛水最多的容器
 * @author weikunkun
 * @since 2021/5/26
 */
public class LC_11 {
    public int maxArea(int[] height) {
        // 双指针(头尾指针)
        int N = height.length;
        int left = 0;
        int right = N - 1;
        int area = 0;
        while (left < right) {
            int hight = Math.min(height[left], height[right]);
            int innerArea = hight * (right - left);
            area = Math.max(area, innerArea);
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return area;
    }
}
