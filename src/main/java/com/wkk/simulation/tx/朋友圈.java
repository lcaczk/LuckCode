package com.wkk.simulation.tx;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/6/18
 */
public class 朋友圈 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int group = sc.nextInt();
        while (group-- > 0) {
            int n = sc.nextInt();
            int[][] matrix = new int[n][2];
            for (int i = 0; i < n; i++) {
                matrix[i][0] = sc.nextInt();
                matrix[i][1] = sc.nextInt();
            }
            System.out.println(calI(matrix));
        }
    }

    private static int calI(int[][] matrix) {
        UnionFind unionFind = new UnionFind();
        for (int[] relation : matrix) {
            unionFind.union(relation[0], relation[1]);
        }
        return Arrays.stream(unionFind.nums).max().getAsInt();
    }

    static class UnionFind {
        private int[] parent = new int[(int)1e7 + 1];
        // 额外添加存储根节点的对应的子树数量
        public int[] nums = new int[(int)1e7 + 1];

        public UnionFind() {
            for (int i = 0; i < parent.length; i++) {
                parent[i] = i;
            }
            // 初始情况下，所有节点都为根节点
            Arrays.fill(nums, 1);
        }

        public int find(int x) {
            // 使用递归查找，避免迭代查找超时
//            while (x != parent[x]) {
//                x = parent[x];
//            }
//            return x;
            if (x == parent[x]) {
                return x;
            }
            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            // 将A的子树 添加到B中
            // 所以B 树中的节点个数变为 num[b] += num[a];
            if (rootB != rootA) {
                parent[rootA] = rootB;
                nums[rootB] += nums[rootA];
            }
        }
    }


    private static int max = Integer.MIN_VALUE;

    private static void cal(int[][] matrix) {
        // 构建图的邻接链表
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int[] row : matrix) {
            List<Integer> first = map.getOrDefault(row[0], new ArrayList<>());
            List<Integer> second = map.getOrDefault(row[1], new ArrayList<>());
            second.add(row[0]);
            first.add(row[1]);
            map.put(row[0], first);
            map.put(row[1], second);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer num : map.keySet()) {
            int inner = 0;
            if (!set.contains(num)) {
                inner += dfs(num, set, map);
            }
            max = Math.max(max, inner);
        }
    }

    private static int dfs(int num, Set<Integer> set, Map<Integer, List<Integer>> map) {
        set.add(num);
        int total = 1;
        for (Integer adjNum : map.get(num)) {
            if (!set.contains(adjNum)) {
                total += dfs(adjNum, set, map);
            }
        }
        return total;
    }

}
