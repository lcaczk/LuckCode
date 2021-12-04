package com.wkk.offer;

import java.util.Arrays;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author weikunkun
 * @since 2021/7/18
 */
public class Offer_40 {
    /**
     * 维护最小堆
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>((x, y) -> (y - x));
        for (int num : arr) {
            if (queue.size() < k) {
                queue.offer(num);
            } else {
                if (queue.peek() > num) {
                    queue.poll();
                    queue.offer(num);
                }
            }
        }
        int[] ans = new int[k];
        int i = 0;
        while (!queue.isEmpty()) {
            ans[i++] = queue.poll();
        }
        return ans;
    }

    /**
     * 使用快速选择
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbersII(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return arr;
        }
        int n = arr.length;
        quickSelect(arr, 0, n - 1, k - 1);
        return Arrays.copyOf(arr, k);
    }

    private void quickSelect(int[] arr, int i, int j, int k) {
        if (i > j) {
            return;
        }
        int pos = partition(arr, i, j);
        if (pos == k) {
            return;
        } else if (pos < k) {
            quickSelect(arr, pos + 1, j, k);
        } else {
            quickSelect(arr, i, pos - 1, k);
        }
    }

    private int partition(int[] nums, int i, int j) {
        int tmp = nums[i];
        while (i < j) {
            while (i < j && nums[j] >= tmp) {
                j--;
            }
            nums[i] = nums[j];
            while (i < j && nums[i] <= tmp) {
                i++;
            }
            nums[j] = nums[i];
        }
        nums[i] = tmp;
        return i;
    }

    public static int[] getLeastNumbersIII(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int[] ans = new int[k];
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int count = entry.getValue();
            while (count-- > 0 && k > 0) {
                arr[idx++] = key;
                k--;
            }
            if (k <= 0) {
                break;
            }
        }
        return ans;
    }

    public static int[] getLeastNumbersIV(int[] arr, int k) {
        // 计数排序
        // 思路 : 明确内部数据的范围， 说白了就是做词频统计
        int[] countArray = new int[10000];
        for (int num : arr) {
            countArray[num]++;
        }
        int[] ans = new int[k];
        int idx = 0;
        for (int i = 0; i < 10000; i++) {
            if (k <= 0) {
                break;
            }
            if (countArray[i] == 0) {
                continue;
            }
            int count = countArray[i];
            while (count > 0 && k > 0) {
                ans[idx++] = i;
                k--;
                count--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] ans = {1, 1, 1, 2, 1, 5};
        getLeastNumbersIV(ans, 5);
    }
}
