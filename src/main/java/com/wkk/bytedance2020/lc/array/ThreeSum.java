package com.wkk.bytedance2020.lc.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Time: 2020/7/24下午4:09
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i< nums.length-2; i++){
            if(i == 0 || nums[i] != nums[i-1]){
                int target = -nums[i];
                int low = i+1;
                int high = nums.length -1;
                while(low < high){
                    int sum = nums[low] + nums[high];
                    if(sum < target){
                        low++;
                    }else if(sum > target){
                        high--;
                    }else {
                        res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                        while(low < high && nums[low] == nums[low+1]){
                            low++;
                        }
                        while(low < high && nums[high] == nums[high-1]){
                            high--;
                        }
                        low++;
                        high--;

                    }
                }
            }
        }
        return res;
    }
}
