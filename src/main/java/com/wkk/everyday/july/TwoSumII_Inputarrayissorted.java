package com.wkk.everyday.july;

import java.util.HashMap;
import java.util.Map;

/**
 * @Time: 2020/7/20上午8:35
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class TwoSumII_Inputarrayissorted {
    public int[] twoSum(int[] numbers, int target) {
        int[] res = new int[2];
        if(numbers== null || numbers.length == 0){
            return res;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<numbers.length; i++){
            map.put(numbers[i], i);
        }
        for(int i = 0; i<=numbers.length/2; i++){
            if(map.containsKey(target - numbers[i])){
                res[0] = i+1;
                res[1] = map.get(target-numbers[i])+1;
                break;
            }
        }
        return res;
    }

    public int[] twoSumII(int[] numbers, int target) {
        // 双指针
        int[] res = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while(i < j){
            int temp = numbers[i] + numbers[j];
            if(temp>target){
                j--;
            }else if(temp < target){
                i++;
            }else{
                res[0] = i+1;
                res[1] = j+1;
                break;
            }
        }
        return res;
    }
}
