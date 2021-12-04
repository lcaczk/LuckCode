package com.wkk.sort;

import java.util.Arrays;
import java.util.TreeSet;

/**
 * @author weikunkun
 * @since 2021/10/6
 */
public class LC_414 {
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        Arrays.stream(nums).forEach(ele -> {
            set.add(ele);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        });
        return set.size() > 3 ? set.first() : set.last();
    }

}
