package com.wkk.array;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * @Time: 20-3-30下午2:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class MajorityElement {
    public int majorityElement(int[] nums) {
        int length = nums.length;
        int ret = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num, map.get(num) + 1);
            }else {
                map.put(num, 1);
            }
            if(map.get(num) > length/2){
                ret = num;
                break;
            }
        }
        return ret;
    }
}
