package com.wkk.prefix;

import java.util.ArrayList;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/8/21
 */
public class LC_346 {
    List<Integer> list =  new ArrayList<>();
    int size = 0;
    int idx = 0;
    /** Initialize your data structure here. */
    public LC_346(int size) {
        this.size = size;
        list.add(0);
    }

    public double next(int val) {
        list.add(list.get(idx) + val);
        idx++;
        if (idx < size) {
            return list.get(idx) / (double)idx;
        } else {
            return (double) (list.get(idx) - list.get(idx - size)) / size;
        }
    }

    public static void main(String[] args) {
        LC_346 lc_346 = new LC_346(1);

    }
}
