package com.wkk.challenge.week1;

import org.omg.CORBA.INTERNAL;

import java.util.HashMap;

/**
 * @Time: 20-4-2上午10:28
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int single = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (Integer integer : map.keySet()) {
            if (map.get(integer) == 1) {
                single = integer;
            }
        }
        return single;
    }

    public static int singleNumbers(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            ans ^= nums[i];

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] a  = {4, 1, 2, 1, 2};
        singleNumbers(a);
    }

}
