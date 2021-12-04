package com.wkk.union;

/**
 * @author weikunkun
 * @since 2021/6/19
 */
public class LC_990 {
    public boolean equationsPossible(String[] equations) {
        UnionFind unionFind = new UnionFind(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                unionFind.union(a, b);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int a = equation.charAt(0) - 'a';
                int b = equation.charAt(3) - 'a';
                if (unionFind.isConnect(a, b)) {
                    return false;
                }
            }
        }
        return true;
    }

    private class UnionFind {
        private int[] parents;

        public UnionFind(int nums) {
            this.parents = new int[nums];
            for (int i = 0; i < nums; i++) {
                parents[i] = i;
            }
        }

        public int find(int x) {
            while (x != parents[x]) {
                parents[x] = parents[parents[x]];
                x = parents[x];
            }
            return x;
        }

        public void union(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            parents[rootA] = rootB;
        }

        public boolean isConnect(int i, int j) {
            return find(i) == find(j);
        }
    }
}
