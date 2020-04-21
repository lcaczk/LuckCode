package com.wkk.array;

import java.util.HashMap;

/**
 * @Time: 20-4-15下午11:27
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ContiguousArray {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int max = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans += nums[i];
            if(hashMap.containsKey(ans)){
                max = Math.max(i-hashMap.get(ans), max);
            }
            else {
                hashMap.put(ans, i);
            }
        }
        return max;
    }
}
