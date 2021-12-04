package com.wkk.simulation.mt;

import java.util.HashMap;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/20
 */
public class 鲜花快递员 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Node[] nds = new Node[n + 1];
        int sum = 0;
        for (int i = 0; i < n - 1; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int w = in.nextInt();
            if (nds[u] == null) nds[u] = new Node();
            if (nds[v] == null) nds[v] = new Node();
            nds[u].neibor.put(nds[v], w);
            nds[v].neibor.put(nds[u], w);
            sum += 2 * w;
        }
        nds[1].visited = true;
        DFS(nds[1], 0);
        int res1 = 0;
        int res2 = 0;
        for (int i = 1; i <= n; i++) {
            res1 += nds[i].dis;
            res2 = Math.max(res2, nds[i].dis);
        }
        res2 = sum - res2;
        System.out.println(res1 + " " + res2);
    }

    public static void DFS(Node root, int dis) {
        for (Node nd : root.neibor.keySet()) {
            if (nd.visited) continue;
            nd.visited = true;
            nd.dis = dis + root.neibor.get(nd);
            DFS(nd, nd.dis);
        }
    }

    public static class Node {
        int dis;
        boolean visited;
        HashMap<Node, Integer> neibor;

        public Node() {
            dis = 0;
            neibor = new HashMap<>();
        }
    }
}
