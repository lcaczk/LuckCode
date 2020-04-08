package com.wkk.array;

import java.util.PriorityQueue;

/**
 * @Time: 20-4-4下午5:18
 * @Author: kongwiki
 * @Email: kongwiki@163.com
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int m = nums.length - k;
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        while (m > 0){
            priorityQueue.poll();
        }
        Integer poll = priorityQueue.poll();
        return poll;
    }

    // 使用快排
    public int quickSort(int[] nums, int k){
        int low = 0;
        int high = nums.length-1;
        while (low < high){
            int position = priori(nums, low, high);

        }
        return 0;
    }

    // 枢轴
    private int priori(int[] nums, int low, int high){
          int prior = nums[low];
          while (low < high){
              while (low< high && nums[low]<= prior){
                  low++;
              }
              nums[high] = nums[low];
              while (low< high && nums[high] >= prior){
                  high--;
              }
              nums[low] = nums[high];
          }
          nums[low] = prior;
          return low;
    }

}
