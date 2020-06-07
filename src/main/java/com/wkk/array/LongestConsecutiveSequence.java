package com.wkk.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * @Time: 2020/6/6上午7:40
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if(nums.length <=1){
            return nums.length;
        }
        Arrays.sort(nums);
        int low =  0;
        int height = 1;
        int count = 0;
        int len = nums.length;
        int max = 0;
        while (height < len){
            if(nums[height] == nums[height-1]){
                count++;
            }
            if(nums[height] - nums[low] != height-low){
                low++;
                height = low+1;
            }
            else{
                height++;
            }
            max = Math.max(max, height-low);
        }
        return max-count;
    }

    public static int longestConsecutiveII(int[] nums){
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) {
            numSet.add(num);
        }
        int count = 0;
        for (Integer integer : numSet) {
            if(!numSet.contains(integer-1)){
                int curr = integer;
                int len = 1;
                while (numSet.contains(curr+1)){
                    curr += 1;
                    len += 1;
                }
                count = Math.max(count, len);

            }
        }
        return count;

    }

    public static void main(String[] args) {
        int[] a = {1,2,0,1};
        LongestConsecutiveSequence lon = new LongestConsecutiveSequence();
        int i = lon.longestConsecutiveII(a);
        System.out.println(i);
    }
}
