package com.wkk.top100.array.easy;

/**
 * 移动零
 * @author kongwiki@163.com
 * @since 2021/2/6
 */
public class LC_283 {
    /**
     * 不为0的元素依次填写，剩余的位置填0补齐
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        // TODO 判空
        int pos = 0;
        for(int num : nums) {
            if (num != 0) {
                nums[pos++] = num;
            }
        }
        while(pos < nums.length) {
            nums[pos++] = 0;
        }
    }

    public void moveZeroesII(int[] nums) {
        int pos = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[pos] = nums[i];
                if (i != pos) {
                    nums[i] = 0;
                }
                pos++;
            }
        }
    }
}
