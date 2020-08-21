package com.wkk.bytedance2020.lc.array;

import java.util.HashSet;
import java.util.Set;

/**
 * @Time: 2020/7/29上午9:32
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int number : nums){
            if(!set.contains(number-1)){
                int count = 1;
                while(set.contains(number+1)){
                    count += 1;
                    number += 1;
                }
                max = Math.max(max, count);

            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        int i = longestConsecutive(a);
        System.out.println(i);
        StringBuilder sb = new StringBuilder();

    }
}
