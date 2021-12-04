package com.wkk.union;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/21
 */
public class LC_305 {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        boolean[] isLand = new boolean[m * n];
        UnionFind union = new UnionFind(m * n);
        List<Integer> res = new ArrayList<>();
        for (int[] p : positions) {
            int x = p[0];
            int y = p[1];
            int idx = x * n + y;
            if (!isLand[idx]) {
                isLand[idx] = true;
                union.add(idx);
                if (x - 1 >= 0 && isLand[idx - n]) {
                    union.union(idx, idx - n);
                }
                if (x + 1 < m && isLand[idx + n]) {
                    union.union(idx, idx + n);
                }
                if (y - 1 >= 0 && isLand[idx - 1]) {
                    union.union(idx, idx - 1);
                }
                if (y + 1 < n && isLand[idx + 1]) {
                    union.union(idx, idx + 1);
                }
            }
            res.add(union.getCount());
        }
        return res;
    }

    class UnionFind {
        // 以 i * n + j 作为一维的地址
        // 连通分量的大小
        private int count;
        // 核心，对应的父节点
        private int[] parents;
        // 每个树的节点数量 （每个连通分量的大小）
        private int[] nums;

        public UnionFind(int n) {
            this.count = 0;
            this.parents = new int[n];
            this.nums = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                nums[i] = 1;
            }
        }

        public int find(int x) {
            // if (x == parents[x]) {
            //     return x;
            // }
            // return parents[x] = find(parents[x]);
            while (x != parents[x]) {
                x = parents[x];
            }
            return x;
        }

        public void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            if (rootA == rootB) {
                return;
            }
            // 优化 提高查找效率
            // 统一规定 nums[i] < nums[j]
            // parents[i] = j;
            else if (nums[rootA] < nums[rootB]) {
                parents[rootA] = rootB;
                nums[rootB] += nums[rootA];
            } else {
                parents[rootB] = rootA;
                nums[rootA] += nums[rootB];
            }
            // parents[rootA] = rootB;
            // nums[rootB] += nums[rootA];
            count--;
        }

        public int getCount() {
            return count;
        }

        public void add(int idx) {
            count++;
        }
    }
}
