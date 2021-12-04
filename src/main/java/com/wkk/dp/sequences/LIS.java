package com.wkk.dp.sequences;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author weikunkun
 * @since 2021/6/14
 */
public class LIS {
    public static int[] LIS(int[] arr) {
        // write code here
        int n = arr.length;
        int[] dp = new int[n];
        dp[0] = 1;
        int max = 1;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            int j = 0;
            while (j < i) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                j++;
            }
            max = Math.max(dp[i], max);
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int j = n - 1; j >= 0 && max > 0; j--) {
            if (dp[j] == max && (stack.isEmpty() || stack.peek() > arr[j])) {
                max--;
                stack.push(arr[j]);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 3, 6, 4, 8, 9, 7};
//        System.out.println(LIS(arr))
//        System.out.println(Integer.MAX_VALUE);
    }
}
