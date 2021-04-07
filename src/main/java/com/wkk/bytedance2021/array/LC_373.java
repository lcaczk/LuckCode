package com.wkk.bytedance2021.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @author weikunkun
 * @since 2021/4/7
 */
public class LC_373 {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> res = new ArrayList<>();
        // 构建一个小根堆
        PriorityQueue<List<Integer>> queue = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o1.get(0) + o1.get(1)) - (o2.get(0) + o2.get(1));
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                List<Integer> out = new ArrayList<>();
                out.add(nums1[i]);
                out.add(nums2[j]);
                queue.offer(out);
            }
        }
        while (k > 0) {
            if (!queue.isEmpty()) {
                res.add(queue.poll());
            }
            k--;
        }
        return res;
    }

}
