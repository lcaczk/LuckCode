package com.wkk.union;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 并查集思路
 *
 * @author weikunkun
 * @since 2021/6/21
 */
public class LC_128 {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        UnionFind uf = new UnionFind();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - 1)) {
                uf.union(num - 1, num);
            }
        }
        return uf.getMaxNums();
    }

    public class UnionFind {
        // 树
        // key : 自身
        // value : 父节点
        private Map<Integer, Integer> parents;
        // 每个子树的数量
        // key : 自身
        // value : 数量
        private Map<Integer, Integer> nums;

        public UnionFind() {
            parents = new HashMap<>();
            nums = new HashMap<>();
        }

        public int find(int x) {
            if (!parents.containsKey(x)) {
                // 默认指向自己
                parents.put(x, x);
                nums.put(x, 1);
            }
            if (x != parents.get(x)) {
                parents.put(x, find(parents.get(x)));
            }
            return parents.get(x);
        }

        public void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            if (rootA != rootB) {
                parents.put(rootA, rootB);
                int numsA = nums.get(rootA);
                nums.put(rootB,nums.get(rootB) + numsA);
            }
        }

        public int getMaxNums() {
            if (nums.isEmpty()) {
                return 1;
            }
            return Collections.max(nums.entrySet(), Comparator.comparingInt(Map.Entry::getValue)).getValue();
        }
    }
}
