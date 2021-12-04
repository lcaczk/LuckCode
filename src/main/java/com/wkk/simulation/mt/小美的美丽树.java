package com.wkk.simulation.mt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/6/30
 */
public class 小美的美丽树 {
    static HashMap<Integer, ArrayList<Integer>> tree;
    static int node;
    static int maxDiff;
    static boolean[] visited;
    static int[] w;
    static int[] childNum;
    static int[] max,min;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        w= new int[n+1];
        for(int i=0;i<n;i++){
            w[i+1] = sc.nextInt();
        }
        tree = new HashMap();
        for(int i = 0;i<n-1;i++){
            int father = sc.nextInt();
            int child = sc.nextInt();
            ArrayList<Integer> childList = tree.getOrDefault(father,new ArrayList());
            childList.add(child);
            tree.put(father,childList);
            childList = tree.getOrDefault(child,new ArrayList());
            childList.add(father);
            tree.put(child,childList);
        }
        node = 0;
        maxDiff = 0;
        int root = sc.nextInt();
        childNum = new int[n+1];
        visited = new boolean[n+1];
        max = new int[n+1];
        min = new int[n+1];
        dfs(root,k);
        System.out.println(node);
    }

    private static void dfs(int parent, int k) {
        visited[parent] = true;
        // 初始化parent下的最值为parent的节点权重
        max[parent] = w[parent];
        min[parent] = w[parent];
        // 初始情况下，该子树只有一个节点
        childNum[parent] = 1;
        ArrayList<Integer> childList = tree.getOrDefault(parent,new ArrayList());
        for(int i = 0; i <childList.size(); i++){
            int child = childList.get(i);
            if(!visited[child]){
                // 没访问过这个孩子节点就进行深搜
                dfs(child, k);
                max[parent] = Math.max(max[parent], max[child]);
                min[parent] = Math.min(min[parent], min[child]);
                childNum[parent] += childNum[child];
            }
        }
        if(childNum[parent] <= k && max[parent] - min[parent] >= maxDiff){
            // 以parent为根节点的子树满足节点数小于等于k，且最大差值大于等于目前最大
            //System.out.println(parent);
            if(max[parent] - min[parent] > maxDiff){
                // 大于了直接更新，等于的话需要考虑哪个根节点的编号小
                node = parent;
            }else{
                // 如果node还没有赋值，就直接赋值为当前节点，否则取满足要求的节点中编号最小的
                node = node == 0? parent: Math.min(node, parent);
            }
            maxDiff = max[parent] - min[parent];
        }
    }
}
