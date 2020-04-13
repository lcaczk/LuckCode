package com.wkk.array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @Time: 20-4-12下午3:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });
        for (int stone : stones) {
            priorityQueue.offer(stone);
        }
        while (priorityQueue.size()>1){
            int p = priorityQueue.poll();
            int q = priorityQueue.poll();
            int diff = p-q;
            if(diff != 0){
                priorityQueue.offer(diff);
            }
        }
        if(priorityQueue.isEmpty()){
            return 0;
        }else {
            return priorityQueue.peek();
        }
    }
}
