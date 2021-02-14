package com.wkk.top100.array.easy;

import java.util.*;

/**
 * 448 找到所有数组中消失的数字
 * @author weikunkun
 * @since 2021/2/14
 */
public class LC_448 {
    /**
     *
     * 下标从1-n
     * @param nums
     * @return
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        for(int i = 1; i <= nums.length; i++) {
            if(!set.contains(i)) {
                result.add(i);
            }
        }
        return result;
    }
}
