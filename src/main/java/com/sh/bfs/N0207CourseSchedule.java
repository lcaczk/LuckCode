package com.sh.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 题目：207.课程表
 * 题目链接：https://leetcode-cn.com/problems/course-schedule/
 * <p>
 * 题目描述：
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * <p>
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * <p>
 * 提示：
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * <p>
 * Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序
 */
class N0207CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 当前课程为先修课程的后续课程链表（邻接表）
        List<List<Integer>> edges = new ArrayList<>();
        // 每门课程的先修课程数量（入度）
        int[] indeg = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges.add(new LinkedList<>());
        }
        for (int[] p : prerequisites) {
            edges.get(p[1]).add(p[0]);
            indeg[p[0]]++;
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            // 入度为0（无需先修课程的课程）
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        int visited = 0;
        while (!queue.isEmpty()) {
            visited++;
            int pre = queue.poll();
            // 遍历以当前课程为先修课程的后续课程链表
            for (int cur : edges.get(pre)) {
                indeg[cur]--;
                // 如果入度（先修课程数量）为0，加入队列
                if (indeg[cur] == 0) {
                    queue.offer(cur);
                }
            }
        }
        return visited == numCourses;
    }

    public static void main(String[] args) {
        N0207CourseSchedule solution = new N0207CourseSchedule();
        System.out.println(solution.canFinish(2, new int[][]{{1, 0}}));
    }
}