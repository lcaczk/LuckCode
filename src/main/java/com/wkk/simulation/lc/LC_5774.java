package com.wkk.simulation.lc;

import java.util.PriorityQueue;

/**
 * @author weikunkun
 * @since 2021/5/30
 */
public class LC_5774 {
    /**
     * 思路：
     * 两个队列
     * 1。 用于保存空闲服务器
     * 2。 用于保存运行服务器
     *
     * @param servers
     * @param tasks
     * @return
     */
    public static int[] assignTasks(int[] servers, int[] tasks) {
        int N = tasks.length;
        // 0 ： 服务权重
        // 1 下标
        PriorityQueue<int[]> serverQueue = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        for (int i = 0; i < servers.length; i++) {
            serverQueue.offer(new int[]{servers[i], i});
        }
        // 0: end time
        // 1: idx
        PriorityQueue<int[]> taskQueue = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]));
        int[] ans = new int[N];
        int now = 0;
        for (int i = 0; i < N; i++) {
            if (serverQueue.isEmpty()) { // 可用服务器为空
                // 获取最近一个结束的任务
                now = taskQueue.peek()[0];
            } else {  //如果空闲队列里还有服务器
                now = Math.max(i, now);
            }
            // 取出所有now时间点结束的任务
            while (!taskQueue.isEmpty() && now >= taskQueue.peek()[0]) {
                int[] task = taskQueue.poll();
                // 根据服务器的下标获取服务器权重
                serverQueue.offer(new int[]{servers[task[1]], task[1]});
            }
            //取一个空闲服务器，将新任务放入tq
            int[] server = serverQueue.poll();
            taskQueue.offer(new int[]{now + tasks[i], server[1]});
            ans[i] = server[1];
        }
        return ans;

    }

    public static void main(String[] args) {
        int[] servers = {3, 3, 2};
        int[] tasks = {1, 2, 3, 2, 1, 2};
        assignTasks(servers, tasks);
    }
}
