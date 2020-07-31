package com.wkk.array;

/**
 * @author kongwiki@163.com
 * @since 2020/7/30下午8:57
 */
public class JumpGame {
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
