package com.wkk.everyday.june;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 2020/6/27下午8:02
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int max = nums[nums.length-1];
        for(int i = 1; i< max; i++){
            if(!map.containsKey(i)){
                res = i;
                return res;
            }
        }
        return res;
    }

}
