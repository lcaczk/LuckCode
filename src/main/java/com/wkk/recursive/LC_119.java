package com.wkk.recursive;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/28
 */
public class LC_119 {
    private int target;
    public List<Integer> getRow(int rowIndex) {
        // 递归
        this.target = rowIndex;
        return recurtion(rowIndex);
    }

    private List<Integer> recurtion(int idx) {
        if (idx == 0) {
            List<Integer> list = new ArrayList<>();
            list.add(1);
            return list;
        }
        List<Integer> pre = recurtion(idx - 1);
        List<Integer> cur = new ArrayList<>(idx + 1);
        for (int i = 0; i <= idx; i++) {
            if (i == 0 || i == idx) {
                cur.add(1);
            } else {
                int tmp = pre.get(i - 1) + pre.get(i);
                cur.add(tmp);
            }
        }
        return cur;
    }
}
