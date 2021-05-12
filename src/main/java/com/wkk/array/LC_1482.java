package com.wkk.array;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

/**
 * @author weikunkun
 * @since 2021/5/9
 */
public class LC_1482 {

    /**
     * 第一种暴力解决方式超时了
     * 对于数组的连续子集划分可以考虑使用二分查找
     *
     * @param bloomDay
     * @param m
     * @param k
     * @return
     */
    // 数组长度
    private int arrayLen;
    // 采集几束花
    private int group;
    // 每束花的数量为多少
    private int groupSize;
    public int minDaysII(int[] nums, int m, int k) {
        int max = Arrays.stream(nums).max().getAsInt();
        int left = 0;
        int right = max;
        arrayLen = nums.length;
        group = m;
        groupSize = k;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return check(nums, left) ? left : -1;
    }

    // 以mid作为天数，得到能够构成的花束数量cnt
    // 如果cnt > m  则 mid 太大了 需要小一些
    public boolean check(int[] nums, int day) {
        boolean[] flower = new boolean[arrayLen];
        for (int i = 0; i < arrayLen; i++) {
            flower[i] = nums[i] <= day;
        }
        int cnt = 0;
        int j = 0;
        while (j < arrayLen) {
            if (flower[j]) { // 开放了
                int innerSize = 1;
                int k = j + 1;
                while (innerSize < groupSize && k < arrayLen && flower[k]) {
                    innerSize++;
                    k++;
                }
                if (innerSize == groupSize) {
                    cnt++;
                }
                j = k;
            } else {
                j++;
            }
        }
        return cnt > group;
    }

    public static int minDays(int[] bloomDay, int m, int k) {
        int len = bloomDay.length;
        int max = Arrays.stream(bloomDay).max().getAsInt();
        int totalNum = m * k;
        if (totalNum > len) {
            return -1;
        } else if (totalNum == len) {
            return max;
        }
        // 滑动窗口
        // dfs
        List<Integer> list = Arrays.stream(bloomDay).boxed().collect(Collectors.toList());
        Set<Integer> set = new TreeSet<>(list);
        int group = 0;
        int ans = 0;
        for (int elem : set) {
            if (group == m) {
                break;
            }
            group = 0;
            int[] array = Arrays.copyOf(bloomDay, len);
            int count = 0;
            for (int i = 0; i < len; i++) {
                array[i] = array[i] <= elem ? 0 : array[i] - elem;
                if (array[i] == 0) {
                    count++;
                }
            }
            if (count < totalNum) {
                continue;
            }
            // 分组
            int right = 0;
            count = 0;
            while (right < len) {
                if (array[right] == 0) {
                    count++;
                    if (count == k) {
                        group += 1;
                        count = 0;
                    }
                } else {
                    count = 0;
                }
                if (group == m) {
                    ans = elem;
                    break;
                }
                right++;
            }
        }
        return group == 0 ? -1 : ans;

    }

    public static void main(String[] args) {
        int[] array = {62, 75, 98, 63, 47, 65, 51, 87, 22, 27, 73, 92, 76, 44, 13, 90, 100, 85};
        minDays(array, 2, 7);
    }
}
