package com.wkk.simulation.hw;


import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/9/1
 */
public class B {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        int[][] kNode = new int[k][2];
        String[] line = sc.nextLine().split(" ");
        int idx = 0;
        for (String s : line) {
            String[] arr = s.split(",");
            kNode[idx][0] = Integer.parseInt(arr[0]);
            kNode[idx][1] = Integer.parseInt(arr[1]);
            idx++;
        }
        int total = sc.nextInt();
        cal(kNode, k, total);
    }

    /**
     * @param kNode
     * @param k
     * @param total
     */
    private static void cal(int[][] kNode, int k, int total) {
        // 当前节点不同状态下转发的最小结果
        int[][] dp = new int[k][2];
        // 记录直接转发 对应的缓存
        int[] cache = new int[k];
        // 初始化
        // 0 : 选择
        // 1 : 不选择
        // 直转
        int base = kNode[0][0];
        if (total < base) {
            dp[0][0] = total;
            cache[0] = total > kNode[0][1] ? kNode[0][1] : kNode[0][0];
        } else {
            dp[0][0] = base;
            cache[0] = base;
        }
        dp[0][1] = total;
        for (int i = 1; i < k; i++) {
            int curCache = kNode[i][1];
            int curDirect = kNode[i][0];
            int useCurNodeVale = Math.min(dp[i - 1][0], curDirect);
            int notUseValue = Math.min(dp[i - 1][1], curDirect);
            int useCacheValue = Math.min(curCache, Math.min(dp[i - 1][0] - curDirect, 0));
            int notUseCacheValue = Math.min(curCache, Math.min(dp[i - 1][1] - curDirect, 0));
            cache[i] = Math.min(useCacheValue, notUseCacheValue);
            dp[i][0] = Math.min(useCurNodeVale, notUseValue);
            dp[i][1] = dp[i - 1][0];
        }
        int dirMin = Math.min(dp[k - 1][0], dp[k - 1][1]);
        if (k == 1) {
            dirMin = dp[0][0];
        }

        int[][] f = new int[k][2];
        f[0][0] = Math.min(cache[0], kNode[0][1]);
        for (int i = 1; i < k; i++) {
            int curDirect = kNode[i][0];
            int useCurNodeVale = Math.min(f[i - 1][0], curDirect);
            int notUseValue = Math.min(f[i - 1][1], curDirect);
            f[i][0] = Math.min(useCurNodeVale, notUseValue);
            f[i][1] = f[i - 1][0];
        }
        int cacheMin = Math.min(f[k - 1][0], f[k - 1][1]);
        if (k == 1) {
            cacheMin = f[0][0];
        }
        System.out.println(cacheMin + dirMin);
    }
}
