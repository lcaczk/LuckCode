package com.wkk.union;

import java.util.Arrays;
import java.util.List;

/**
 * 并查集
 * 用一个虚拟点作为所有能够移动到陆地的根节点
 * 方便统计为1 但是不连通的数量
 *
 * @author weikunkun
 * @since 2021/6/26
 */
public class LC_1020 {
    class UnionFindSet {
        public int[] pre;

        public UnionFindSet(int num) {
            this.pre = new int[num];
            for (int i = 0; i < this.pre.length; i++) {
                this.pre[i] = i;
            }
        }

        public int find(int x) {
            int root = x;
            while (this.pre[root] != root) {
                root = this.pre[root];
            }
            // 路径压缩
            while (this.pre[x] != x) {
                int tmp = this.pre[x];
                this.pre[x] = root;
                x = tmp;
            }
            return root;
        }

        public void union(int x, int y) {
            this.pre[find(x)] = find(y);
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int numEnclaves(int[][] A) {
        // 并查集, 海洋和边界上的陆地构成联通区域表示可以离开， 统计剩余的陆地单元格个数
        if (A == null || A.length == 0) {
            return 0;
        }
        int rows = A.length, cols = A[0].length;
        UnionFindSet ufs = new UnionFindSet(rows * cols + 1);
        // 用一个虚拟节点表示联通到边界的陆地
        int dummy = rows * cols;
        List<Pair> direction = Arrays.asList(new Pair(-1, 0), new Pair(1, 0), new Pair(0, -1), new Pair(0, 1));
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // 是否为于边界
                if (A[i][j] == 1) {
                    if (i == 0 || j == 0 || i == rows - 1 || j == cols - 1) {
                        ufs.union(i * cols + j, dummy);
                    }
                    // 联通上下左右的陆地
                    else {
                        for (Pair pair : direction) {
                            int x = i + pair.x, y = j + pair.y;
                            if (x >= 0 && x < rows && y >= 0 && y < cols && A[x][y] == 1) {
                                ufs.union(i * cols + j, x * cols + y);
                            }
                        }
                    }
                }
            }
        }
        // 统计不和dummy联通的1的个数
        int res = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (A[i][j] == 1 && !ufs.isConnected(i * cols + j, dummy)) {
                    res += 1;
                }
            }
        }
        return res;
    }
}
