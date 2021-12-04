package com.wkk.dfs;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 树的重心
 *
 * @author weikunkun
 * @since 2021/8/19
 */
public class AC_846 {
    /**
     * 树的重心。
     * 策略：
     * 1. dfs均可将一个连通图中的点遍历完，dfs使用更简洁，一般无特殊要求可用dfs
     * 2. 每次dfs时，返回dfs的结点的子树大小sum，故对于每个儿子返回的sum值，当前结点做以下处理：
     * 3. 比较各个子树的sum选择一个最大值；此外，除了这个子树后剩余的部分的个数也参与比较
     * 4. 注意：这是一颗树，故任何一个结点都可以作为主根向下遍历
     */
    static final int N = 100_010;
    static int[] h = new int[N];                //结点，即原来单链表的head
    static boolean[] status = new boolean[N];   //当前结点是否被搜过

    static final int M = N * 2;     //n-1条无向边需要两倍空间来存储
    static int[] e = new int[M];    //边结点，存储的值为被指向的结点
    static int[] ne = new int[M];   //邻接表上该边结点的下一条边(边结点）
    static int idx;

    static int n;
    static int ans = N;    //该题答案

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Arrays.fill(h, 1, n + 1, -1);    //结点从1开始，开始时边为空，即h数组值为-1表示无出边
        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            add(a, b);
            add(b, a);
        }
        dfs(1);
        System.out.println(ans); //从第一个结点开始深度优先遍历
    }

    static void add(int a, int b) {
        e[idx] = b;
        ne[idx] = h[a];
        h[a] = idx++;
    }

    //以u为根结点的子树大小
    static int dfs(int u) {
        status[u] = true;

        int sum = 1;    //当前子树大小，包括自己故从1开始
        int res = 0;    //删除该结点后每一个连通块大小的最大值
        for (int i = h[u]; i != -1; i = ne[i]) {
            int j = e[i];
            if (!status[j]) {
                int s = dfs(j);         //其儿子子树的大小
                res = Math.max(res, s); //找出儿子子树中的最大值
                sum += s;               //以u为根节点的子树大小
            }
        }
        res = Math.max(res, n - sum); //每个结点dfs最终得出的这个res即为以该结点为重心，删除后各个连通块中点数的最大值
        ans = Math.min(res, ans);
        return sum;
    }
}