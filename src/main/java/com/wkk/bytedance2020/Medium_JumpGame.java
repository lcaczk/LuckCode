package com.wkk.bytedance2020;

/**
 * @Time: 2020/7/19上午7:51
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class Medium_JumpGame {
    public boolean canJump(int[] nums) {
        int rightLest = 0;
        int n = nums.length-1;
        for(int i = 0; i<=n; i++){
            if(i <= rightLest){
                rightLest = Math.max(rightLest, nums[i] +i);
                if(rightLest >= n){
                    return true;
                }
            }
        }
        return false;
    }
}
