package com.wkk.dfs;

import com.common.structure.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class LC_690 {
    private Map<Integer, Employee> map = new HashMap<>();
    public int getImportance(List<Employee> employees, int id) {
        // dfs
        if (employees.isEmpty()) {
            return 0;
        }
        // map key: id. value: employee
        for (Employee employee : employees) {
            map.put(employee.id, employee);
        }
        return dfs(id, 0);
    }

    private int dfs(int id, int importance) {
        Employee employee = map.get(id);
        importance += employee.importance;
        for (Integer adjId : employee.subordinates) {
            Employee nextEm = map.get(adjId);
            importance += nextEm.importance;
            dfs(nextEm.id, importance);
        }
        return importance;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.sort(list);
    }
}
