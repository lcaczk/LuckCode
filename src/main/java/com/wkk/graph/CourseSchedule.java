package com.wkk.graph;

import java.util.*;

/**
 * 题目：课程表
 * @author kongwiki@163.com
 * @since 2020/9/10 3:41 下午
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjaceny = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            adjaceny.add(new ArrayList<>());
        }
        for (int[] cps : prerequisites) {
            indegrees[cps[0]] ++;
            adjaceny.get(cps[1]).add(cps[0]);
        }
        for (int i = 0; i < numCourses; i++) {
            if(indegrees[i] == 0){
                queue.add(i);
            }
        }

        while (!queue.isEmpty()){
            Integer pre = queue.poll();
            numCourses--;
            for (Integer integer : adjaceny.get(pre)) {
                if(--indegrees[integer] == 0){
                    queue.add(integer);
                }
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {

    }
}
