package com.wkk.binarysearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Time: 20-3-30下午6:20
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (Integer integer : set1) {
            if(set2.contains(integer)){
                list.add(integer);
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;

    }
}
