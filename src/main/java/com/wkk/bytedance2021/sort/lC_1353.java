package com.wkk.bytedance2021.sort;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author weikunkun
 * @since 2021/4/1
 */
public class lC_1353 {
    public int maxEvents(int[][] events) {
        //将会议按开始时间排序
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        //小顶堆，存放会议的结束时间
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int day = 0, id = 0, n = events.length, res = 0;
        while (id < n || !queue.isEmpty()) {
            if (queue.isEmpty()) {
                queue.add(events[id][1]);
                //day记录当前时间
                day = events[id++][0];
            }
            //把当前可以参加的会议加入到小顶堆
            // （现在还未能参加的会议先不考虑，开始时间比当前时间大的会议就是现在还未能参加）
            while (id < n && events[id][0] <= day) {
                queue.add(events[id++][1]);
            }

            //选取结束时间最早的的会议，把当天分配给它
            if (queue.peek() >= day) {
                day++;
                res++;
            }
            queue.poll();
        }
        return res;
    }
}
