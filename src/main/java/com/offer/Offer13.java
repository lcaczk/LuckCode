package com.offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目：剑指 Offer 13.机器人的运动范围
 * 题目链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * 标签：广度优先搜索
 * <p>
 * 题目描述：
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。
 * 一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），
 * 也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * <p>
 * 提示：
 * 1 <= n,m <= 100
 * 0 <= k <= 20
 */
class Offer13 {
    int getNumSum(int i, int j) {
        int sum = 0;
        while (i != 0) {
            sum += i % 10;
            i /= 10;
        }
        while (j != 0) {
            sum += j % 10;
            j /= 10;
        }
        return sum;
    }

    public int movingCount(int m, int n, int k) {
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        // 队列
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] ij = queue.poll();
            int i = ij[0];
            int j = ij[1];
            if (i >= m || j >= n || k < getNumSum(i, j) || visited[i][j]) {
                continue;
            }
            visited[i][j] = true;
            res++;
            // 向右、向下
            queue.add(new int[]{i + 1, j});
            queue.add(new int[]{i, j + 1});
        }
        return res;
    }


    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        // si：i的和，sj：j的和
        return dfs(0, 0, 0, 0, m, n, k, visited);
    }

    int dfs(int i, int j, int si, int sj, int m, int n, int k, boolean[][] visited) {
        if (i >= m || j >= n || si + sj > k || visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        // si和sj的更新优化：
        // 如果是9、19、29...等下一步更新为10、20、30...对应数位和为9-8=1、10-8=2、11-8=3...
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj, m, n, k, visited) +
                dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1, m, n, k, visited);
    }

    public static void main(String[] args) {
        Offer13 solution = new Offer13();
        System.out.println(solution.movingCount(2, 3, 1));
        System.out.println(solution.movingCount2(2, 3, 1));
        System.out.println(solution.movingCount(3, 1, 0));
        System.out.println(solution.movingCount2(3, 1, 0));
        System.out.println(solution.movingCount(1, 2, 1));
        System.out.println(solution.movingCount2(1, 2, 1));
        System.out.println(solution.movingCount(16, 8, 4));
        System.out.println(solution.movingCount2(16, 8, 4));
    }
}
