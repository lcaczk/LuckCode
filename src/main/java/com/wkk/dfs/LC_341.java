package com.wkk.dfs;

import com.common.structure.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/6/3
 */
public class LC_341 implements Iterator<Integer> {
    List<Integer> allEle;
    Iterator<Integer> cur;
    public LC_341(List<NestedInteger> nestedList) {
        allEle = new ArrayList<>();
        dfs(nestedList);
        cur = allEle.iterator();
    }

    @Override
    public Integer next() {
        return cur.next();
    }

    @Override
    public boolean hasNext() {
        return cur.hasNext();
    }

    private void dfs(List<NestedInteger> list) {
        for (NestedInteger integer : list) {
            if (integer.isInteger()) {
                allEle.add(integer.getInteger());
            } else {
                dfs(integer.getList());
            }
        }
    }
}
