package com.wkk.array;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * 存在重复元素 III
 *
 * @author weikunkun
 * @since 2021/4/17
 */
public class LC_220 {
    /**
     * 暴力 超时
     *
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        // k 索引差
        // t 数值差
        // boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            while (j < nums.length && (j - i) <= k) {
                if (Math.abs((long) nums[i] - (long) nums[j]) <= (long) t) {
                    return true;
                }
                j++;
            }
        }
        return false;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateII(int[] nums, int k, int t) {
        // k 索引差
        // t 数值差
        // boolean flag = false;
        // 滑动窗口
        int left = 0;
        int right = k;
        int len = nums.length;
        while (right < len) {
            if (isMasDiffLessThanT(nums, left, right, t)) {
                return true;
            }
            left++;
            right++;
        }
        return false;
    }

    private static boolean isMasDiffLessThanT(int[] array, int left, int right, int t) {
        int[] temp = new int[right - left + 1];
        int i = 0;
        while (left <= right) {
            temp[i++] = array[left];
            left++;
        }
        Arrays.sort(temp);
        return Math.abs((long) temp[0] - (long) temp[temp.length - 1]) <= (long) t;
    }

    /**
     * 滑动窗口
     * @param nums
     * @param k
     * @param t
     * @return
     */
    public static boolean containsNearbyAlmostDuplicateIII(int[] nums, int k, int t) {
        int n = nums.length;
        TreeSet<Long> set = new TreeSet<Long>();
        for (int i = 0; i < n; i++) {
            Long ceiling = set.ceiling((long) nums[i] - (long) t);
            if (ceiling != null && ceiling <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (i >= k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 1};
        containsNearbyAlmostDuplicateIII(array, 3, 0);
    }
}
