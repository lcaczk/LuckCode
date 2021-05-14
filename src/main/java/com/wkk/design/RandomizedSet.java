package com.wkk.design;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/5/13
 */
public class RandomizedSet {
    private List<Integer> list;
    private Set<Integer> set;
    Random rand = new Random();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        set = new HashSet<>();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        list.add(val);
        if (set.contains(val)) {
            return false;
        } else {
            set.add(val);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        Integer objVal = Integer.valueOf(val);
        if (!set.contains(objVal)) {
            return false;
        }
        return list.remove(objVal);
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return list.get(rand.nextInt(list.size()));
    }
}
