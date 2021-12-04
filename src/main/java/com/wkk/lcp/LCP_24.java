package com.wkk.lcp;

import java.util.PriorityQueue;

/**
 * @author weikunkun
 * @since 2021/10/1
 */
public class LCP_24 {
    public int[] numsGame(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] -= i;
        }
        result[0] = 0;
        MedianFinder finder = new MedianFinder();
        finder.addNum(nums[0]);
        for (int i = 1; i < n; i++) {
            finder.addNum(nums[i]);
            int median = finder.findMedian();
            long value = finder.minSum - (long) (finder.minHeap.size() - 1) * (long) median
                    + ((long) (finder.maxHeap.size() - 1) * (long) median - finder.maxSum);
            result[i] = (int) (value % 1000000007);
        }
        return result;
    }

    class MedianFinder {
        PriorityQueue<Integer> minHeap, maxHeap;
        long minSum = 0, maxSum = 0;

        public MedianFinder() {
            minHeap = new PriorityQueue<>();
            maxHeap = new PriorityQueue<>(1, (x, y) -> {
                long result = (long) y - (long) x;
                if (result > 0)
                    return 1;
                if (result < 0)
                    return -1;
                return 0;
            });
            minHeap.add(Integer.MAX_VALUE);
            maxHeap.add(Integer.MIN_VALUE);
        }

        private void adjust() {
            int maxSize = maxHeap.size(), minSize = minHeap.size();
            if (maxSize - minSize >= 2) {
                int num = maxHeap.poll();
                maxSum -= num;
                minHeap.add(num);
                minSum += num;
            } else if (minSize - maxSize >= 2) {
                int num = minHeap.poll();
                minSum -= num;
                maxHeap.add(num);
                maxSum += num;
            }
        }

        public void addNum(int num) {
            int lowerMax = maxHeap.peek();
            if (num <= lowerMax) {
                maxHeap.add(num);
                maxSum += num;
            } else {
                minHeap.add(num);
                minSum += num;
            }
            adjust();
        }

        public int findMedian() {
            if (maxHeap.size() > minHeap.size()) {
                return maxHeap.peek();
            } else {
                return minHeap.peek();
            }
        }
    }
}
