package com.wkk.dp.sequences;

import java.util.Arrays;

/**
 * @author weikunkun
 * @since 2021/9/20
 */
public class LC_673 {
    public static int findNumberOfLIS(int[] nums) {
        int n = nums.length;
        // 用于统计 以当前元素为结尾时，最长递增子序列的长度
        int[] longest = new int[n];
        // 用于统计 以当前元素为结尾时，递增子序列的个数
        int[] counts = new int[n];
        Arrays.fill(longest, 1);
        Arrays.fill(counts, 1);
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) { // 符合递增子序列条件
                    if (longest[i] < longest[j] + 1) {
                        longest[i] = longest[j] + 1;
                        counts[i] = counts[j];
                    } else if (longest[i] == longest[j] + 1) {
                        longest[i] = longest[j] + 1;
                        counts[i] += counts[j];
                    }
                }
            }
        }
        int ans = 0;
        int maxLong = Arrays.stream(longest).max().getAsInt();
        for (int i = 0; i < n; i++) {
            if (longest[i] == maxLong) {
                ans += counts[i];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 4, 7};
        System.out.println(findNumberOfLIS(arr));
    }
}
