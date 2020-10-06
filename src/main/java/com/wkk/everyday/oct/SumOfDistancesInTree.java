package com.wkk.everyday.oct;

import java.util.ArrayList;
import java.util.List;

/**
 * 题目: 树中距离之和
 * 题目链接: https://leetcode-cn.com/problems/sum-of-distances-in-tree
 * <p>
 * 描述:
 * 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1条边。
 * 第 i 条边连接节点edges[i][0] 和 edges[i][1]。
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans
 * <p>
 * 思路: dp， 真的想不到。。。
 *
 * @author kongwiki@163.com
 * @since 2020/10/6
 */
public class SumOfDistancesInTree {
    int[] ans;
    int[] sz;
    int[] dp;
    List<List<Integer>> graph;

    public int[] sumOfDistancesInTree(int N, int[][] edges) {
        ans = new int[N];
        sz = new int[N];
        dp = new int[N];
        graph = new ArrayList<List<Integer>>();
        for (int i = 0; i < N; ++i) {
            graph.add(new ArrayList<Integer>());
        }
        for (int[] edge: edges) {
            int u = edge[0], v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(0, -1);
        dfs2(0, -1);
        return ans;
    }

    public void dfs(int u, int f) {
        sz[u] = 1;
        dp[u] = 0;
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            dfs(v, u);
            dp[u] += dp[v] + sz[v];
            sz[u] += sz[v];
        }
    }

    public void dfs2(int u, int f) {
        ans[u] = dp[u];
        for (int v: graph.get(u)) {
            if (v == f) {
                continue;
            }
            int pu = dp[u], pv = dp[v];
            int su = sz[u], sv = sz[v];

            dp[u] -= dp[v] + sz[v];
            sz[u] -= sz[v];
            dp[v] += dp[u] + sz[u];
            sz[v] += sz[u];

            dfs2(v, u);

            dp[u] = pu;
            dp[v] = pv;
            sz[u] = su;
            sz[v] = sv;
        }
    }
}
