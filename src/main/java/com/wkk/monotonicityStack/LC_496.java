package com.wkk.monotonicityStack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/3/6
 */
public class LC_496 {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[findNums.length];
        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() > nums[i]) {
                Integer peekNumber = stack.pop();
                map.put(peekNumber, nums[i]);
            }
            stack.push(nums[i]);
        }
        while (!stack.isEmpty()) {
            map.put(stack.pop(), -1);
        }
        int i = 0;
        while (i < findNums.length) {
            res[i++] = map.get(findNums[i]);
        }
        return res;
    }

    public static int[] nextGreaterElementI(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            while (!stack.isEmpty() && stack.peek() < nums2[i]) {
                int num = stack.pop();
                map.put(num, nums2[i]);
            }
            stack.push(nums2[i]);
        }
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums1[i])) {
                ans[i] = map.get(nums1[i]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
//        LC_496 lc_496 = new LC_496();
//        lc_496.nextGreaterElement(nums1, nums2);
        nextGreaterElementI(nums1, nums2);
    }
}
