package com.sh.slidingwindow;

import java.util.LinkedList;

/**
 * 题目：239.滑动窗口最大值
 * 题目链接：https://leetcode-cn.com/problems/sliding-window-maximum/
 * <p>
 * 题目描述：
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 * <p>
 * 进阶：
 * 你能在线性时间复杂度内解决此题吗？
 * <p>
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7]
 * 解释:
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * 1 [3  -1  -3] 5  3  6  7       3
 * 1  3 [-1  -3  5] 3  6  7       5
 * 1  3  -1 [-3  5  3] 6  7       5
 * 1  3  -1  -3 [5  3  6] 7       6
 * 1  3  -1  -3  5 [3  6  7]      7
 * <p>
 * 提示：
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * <p>
 * Related Topics 堆 Sliding Window
 */
class L0239SlidingWindowMaximum {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int[] res = new int[nums.length - k + 1];

        // 双端队列，保存当前窗口最大值，保证队列中数值按从大到小排序
        LinkedList<Integer> queue = new LinkedList<>();
        while (right < nums.length) {
            // 保证从大到小，如果前面数小则需要依次弹出，直至满足要求
            while (!queue.isEmpty() && nums[right] > queue.peekLast()) {
                queue.removeLast();
            }
            queue.add(nums[right]);
            right++;
            if (right < k) {
                continue;
            }
            // 当前窗口最大值
            res[left++] = queue.peekFirst();
            // 如果第一个值在窗口外面，移除
            if (queue.peekFirst() == nums[right - k]) {
                queue.removeFirst();
            }
        }
        return res;
    }
}
