package com.offer;

/**
 * 题目：剑指 Offer 21.调整数组顺序使奇数位于偶数前面
 * 题目链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/
 * 标签：
 * <p>
 * 题目描述：
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。
 * <p>
 * 示例：
 * 输入：nums = [1,2,3,4]
 * 输出：[1,3,2,4]
 * 注：[3,1,2,4] 也是正确的答案之一。
 * <p>
 * 提示：
 * 1 <= nums.length <= 50000
 * 1 <= nums[i] <= 10000
 */
class Offer21 {
    public int[] exchange(int[] nums) {
        // 双指针
        int p1 = 0;
        int p2 = nums.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && nums[p1] % 2 == 1) {
                p1++;
            }
            while (p1 < p2 && nums[p2] % 2 == 0) {
                p2--;
            }
            int tmp = nums[p1];
            nums[p1] = nums[p2];
            nums[p2] = tmp;
        }
        return nums;
    }
}