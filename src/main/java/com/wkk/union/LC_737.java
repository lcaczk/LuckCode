package com.wkk.union;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/21
 */
public class LC_737 {
    public boolean areSentencesSimilarTwo(String[] sentence1, String[] sentence2, List<List<String>> similarPairs) {
        int n1 = sentence1.length;
        int n2 = sentence2.length;
        if (n1 != n2) {
            return false;
        }
        // 必须一一对应
        // 1. 构建句子中的每个单词的唯一index
        int idx = 0;
        Map<String, Integer> map = new HashMap<>();
        for (List<String> list : similarPairs) {
            for (String str : list) {
                map.put(str, idx);
                idx++;
            }
        }
        // 2. 将 similarPairs 放入 并查集中
        UnionFind uf = new UnionFind(idx + 1);
        for (List<String> list : similarPairs) {
            String str = list.get(0); // 默认第一个元素为根节点
            idx = map.get(str);
            for (int i = 1; i < list.size(); i++) {
                int curIdx = map.get(list.get(i));
                uf.union(idx, curIdx);
            }
        }
        // 遍历两个sentences 如果不为相似，返回
        // 如果都不存在，判断自身是否相同
        for (int i = 0; i < n1; i++) {
            int first = map.getOrDefault(sentence1[i], -1);
            int second = map.getOrDefault(sentence2[i], -1);
            if (first == -1 || second == -1) {
                if (!sentence1[i].equals(sentence2[i])) {
                    return false;
                }
            } else if (!uf.isConnect(first, second)) {
                return false;
            }

        }
        return true;
    }

    class UnionFind {
        private int[] parents;

        public UnionFind(int nums) {
            this.parents = new int[nums];
            for (int i = 0; i < nums; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            if (x == parents[x]) {
                return x;
            }
            return parents[x] = find(parents[x]);
        }

        public void union(int x, int y) {
            int rootA = find(x);
            int rootB = find(y);
            if (rootA != rootB) {
                parents[rootA] = rootB;
            }
        }

        public boolean isConnect(int x, int y) {
            return find(x) == find(y);
        }
    }

    public static void main(String[] args) {
        String[] a = {"I", "love", "leetcode"};
        String[] b = {"I", "love", "onepiece"};
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("manga", "hunterXhunter"));
        list.add(Arrays.asList("platform", "anime"));
        list.add(Arrays.asList("leetcode", "platform"));
        list.add(Arrays.asList("anime", "manga"));
//        System.out.println(areSentencesSimilarTwo(a, b, list));
    }
}
