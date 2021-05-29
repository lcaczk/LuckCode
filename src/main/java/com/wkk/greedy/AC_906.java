package com.wkk.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 906. 区间分组
 *
 * @author weikunkun
 * @since 2021/5/22
 */
public class AC_906 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[][] martrix = new int[len][2];
        int k = 0;
        while (k < len) {
            martrix[k][0] = sc.nextInt();
            martrix[k][1] = sc.nextInt();
            k++;
        }
        Arrays.sort(martrix, (x, y) -> (x[0] - y[0]));//按左端点从小到达排序
        //用一个小根堆来维护组的一个端点最大值
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int i = 0; i < len; i++) {
            if (heap.isEmpty() || heap.peek() >= martrix[i][0])//堆是空或者堆的对顶是大于等于左端点 ,需要开一共新的组
                heap.add(martrix[i][1]);
            else {//说明当前区间可以放到某一组中，就把他放到最小值的组中
                heap.poll();
                heap.add(martrix[i][1]);
            }
        }
        System.out.println(heap.size());
    }
}
