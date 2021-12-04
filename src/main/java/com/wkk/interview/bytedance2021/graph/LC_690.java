package com.wkk.interview.bytedance2021.graph;

import com.common.structure.Employee;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/5/1
 */
public class LC_690 {
    Map<Integer, Employee> map = new HashMap<Integer, Employee>();

    /**
     * 深度遍历
     * @param employees
     * @param id
     * @return
     */
    public int getImportance(List<Employee> employees, int id) {
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id);
    }

    public int dfs(int id) {
        Employee employee = map.get(id);
        int total = employee.importance;
        List<Integer> subordinates = employee.subordinates;
        for (int subId : subordinates) {
            total += dfs(subId);
        }
        return total;
    }

    /**
     * 广度遍历
     * @param employees
     * @param id
     * @return
     */
    public int getImportanceII(List<Employee> employees, int id) {
        Map<Integer, Employee> map = employees.stream().collect(Collectors.toMap(info -> info.id, employee -> employee));
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        int sum = 0;
        while (!queue.isEmpty()) {
            id = queue.poll();
            Employee employee = map.get(id);
            sum += employee.importance;
            for (int nextId : employee.subordinates) {
                queue.offer(nextId);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
    }
}
