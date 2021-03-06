package com.wkk.monotonicityStack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

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

    public static void main(String[] args) {
        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        LC_496 lc_496 = new LC_496();
        lc_496.nextGreaterElement(nums1, nums2);
    }
}
