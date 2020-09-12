package com.wkk.graph;

import java.util.*;

/**
 * 题目：课程表
 *
 * @author kongwiki@163.com
 * @since 2020/9/10 3:41 下午
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度数组
        int[] indegrees = new int[numCourses];
        // 图使用邻接表存储
        List<List<Integer>> adjaceny = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        // 以下为构造邻接表和入度
        for (int i = 0; i < numCourses; i++) {
            adjaceny.add(new ArrayList<>());
        }
        // 根据题意： cps[1]为当前顶点，cps[0]为cps[1]指向顶点
        for (int[] cps : prerequisites) {
            indegrees[cps[0]]++;
            adjaceny.get(cps[1]).add(cps[0]);
        }
        // 寻找入度为0的顶点，也就是没有前驱的顶点，说明以改点作为起始点
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.add(i);
            }
        }
        // 从该点出发，在图中删除该点之后，检测下一个入度为0的顶点加入队列
        while (!queue.isEmpty()) {
            Integer pre = queue.poll();
            numCourses--;
            for (Integer integer : adjaceny.get(pre)) {
                if (--indegrees[integer] == 0) {
                    queue.add(integer);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] a = {{3, 0}, {3, 1}, {4, 3}, {1, 0}, {4, 2}, {2, 1}, {2, 3}};
        CourseSchedule schedule = new CourseSchedule();
        boolean b = schedule.canFinish(5, a);
        System.out.println(b);

    }

}
