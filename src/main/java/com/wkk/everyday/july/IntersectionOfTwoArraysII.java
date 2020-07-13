package com.wkk.everyday.july;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 2020/7/13上午9:49
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IntersectionOfTwoArraysII {
    // 使用两个hashmap map1, map2统计两个数组中元素的次数
    // 使用一个hashmap map3存储重复的元素, value为map1, map2最小的次数值
    // 然后通过map3 创建数组即为返回结果
    public static int[] intersect(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        Map<Integer, Integer> map1 = new HashMap<>(nums1.length);
        Map<Integer, Integer> map2 = new HashMap<>(nums2.length);
        for (int i = 0; i < m; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }

        for (int i = 0; i < n; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }
        HashMap<Integer, Integer> map3 = new HashMap<>();
        int x = 0;
        for (Integer k : map1.keySet()) {
            if (map2.containsKey(k)) {
                map3.put(k, Math.min(map1.get(k), map2.get(k)));
                x += Math.min(map1.get(k), map2.get(k));
            }
        }
        int[] res = new int[x];
        x = 0;
        int temp = 0;
        for (Map.Entry<Integer, Integer> entry : map3.entrySet()) {
            Integer key = entry.getKey();
            x += entry.getValue();
            for (int i = temp; i < x; i++) {
                res[i] = key;
            }
            temp = x;
        }

        return res;

    }

    public static int[] intersectII(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersectII(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


    public static void main(String[] args) {
        int[] a = {4, 9, 9, 5};
        int[] b = {9, 4, 9, 8, 4};
        intersect(a, b);
    }
}
