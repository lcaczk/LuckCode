package com.wkk.bytedance2021.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * 315 计算右侧小于但前元素的个数
 * @author weikunkun
 * @since 2021/3/31
 */
public class LC_315 {

    /**
     * 暴力
     * @param nums
     * @return
     */
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        // 暴力
        for(int i = 0; i < nums.length-1; i++) {
            int cur = nums[i];
            int count = 0;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < cur) {
                    count++;
                }
            }
            res.add(count);
        }
        res.add(0);
        return res;
    }
}
