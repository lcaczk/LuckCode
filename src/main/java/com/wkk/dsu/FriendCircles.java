package com.wkk.dsu;

/**
 * @Time: 2020/6/8上午10:53
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FriendCircles {
    public int findCircleNum(int[][] M) {
        int n = M.length;
        Union union = new Union(n);

        int size = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (M[i][j] == 1 && i != j) {
                    union.union(i, j);
                }
            }
        }
        for (int i = 0; i < union.parent.length; i++) {
            if (union.parent[i] == i) {
                size++;
            }
        }
        for (int i = 0; i < union.parent.length; i++) {
            System.out.println("节点: " + (i+1) + " 父节点: " + (union.parent[i]+1));
        }
        return size;
    }

    private class Union {
        private int[] parent;

        public Union(int size) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
        }

        public int find(int x){
            while ( x != parent[x]){
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void union(int a, int b){
            int rootA = find(a);
            int rootB = find(b);
            parent[rootA] =  rootB;
        }

    }

    public static void main(String[] args) {
        int[][] matrixI = {{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}};
        int[][] matrixII = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] matrixIII = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
        FriendCircles circles = new FriendCircles();
        int circleNum = circles.findCircleNum(matrixIII);
        System.out.println(circleNum);
    }
}
