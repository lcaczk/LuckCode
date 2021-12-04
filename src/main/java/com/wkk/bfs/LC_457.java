package com.wkk.bfs;

/**
 * @author weikunkun
 * @since 2021/8/7
 */
public class LC_457 {
    public static boolean circularArrayLoop(int[] nums) {
        // 思路
        // 图的遍历，判断是否存在环
        // 可以按照安全点的思路来做
        // 实现
        // bfs、dfs、拓扑
        int n = nums.length;
        int base = 10000;
        // nextIdx = ((curIdx + nums[i]) % n + n) % n;
        for (int i = 0; i < n; i++) {
            if (nums[i] >= base) {
                continue;
            }
            int k = i;
            int s = base + i;
            int t = nums[k] > 0 ? 1 : -1;
            int last = -1;
            do {
                int p = ((k + nums[k]) % n + n) % n; // 要跳到的下一个位置
                last = nums[k]; // 当前步长 （包含方向和长度）
                nums[k] = s;
                k = p;
            } while (k != i && nums[k] < base && (t ^ (nums[k] > 0 ? 1 : -1)) == 0); // 没有被访问过，并且是同一个方向
            if (last % n != 0 && nums[k] == s) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {2, -1, 1, 2, 2};
        int[] array = {-1, 2};
        int[] ary = {1, 1, -3, -2, 0};
        circularArrayLoop(arr);
    }
}
