package com.wkk.weekcompete;

import java.util.HashMap;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/5/16
 */
public class FindSumPairs {
    private int[] nums1;
    private int[] nums2;
    private Map<Integer, Integer> map = new HashMap<>();

    public FindSumPairs(int[] nums1, int[] nums2) {
        this.nums1 = nums1;
        this.nums2 = nums2;

        for (int i : nums2) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
    }

    /**
     * 指定位置添加
     *
     * @param index
     * @param val
     */
    public void add(int index, int val) {
        int temp = nums2[index];
        map.put(temp, map.get(temp) - 1);
        nums2[index] += val;
        map.put(nums2[index], map.getOrDefault(nums2[index], 0) + 1);
    }

    public int count(int tot) {
        int count = 0;
        for (int i = 0; i < nums1.length; i++) {
            int rst = tot - nums1[i];
            if (map.containsKey(rst)) {
                count += map.get(rst);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arrat = {1, 1, 2, 2, 2, 3};
        int[] b = {1, 4, 5, 2, 5, 4};
        FindSumPairs pairs = new FindSumPairs(arrat, b);
        System.out.println(pairs.count(7));
        pairs.add(3, 2);
        System.out.println(pairs.count(8));
        System.out.println(pairs.count(4));
    }
}
