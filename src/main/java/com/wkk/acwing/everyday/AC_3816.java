package com.wkk.acwing.everyday;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author weikunkun
 * @since 2021/8/25
 */
public class AC_3816 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            boolean res = cal(arr, n);
            if (res) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }

    private static boolean cal(int[] nums, int n) {
        long sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 == 1) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        long cur = 0;
        long rst = 0;
        // 正序
        for (int i = 0; i < n; i++) {
            cur += nums[i];
            set.add(nums[i]);
            rst = sum - cur;
            if (cur == rst) {
                return true;
            } else if (cur > rst) {
                int need = (int) ((2 * cur - sum) / 2);
                if (set.contains(need)) {
                    return true;
                }
            }
        }
        cur = 0;
        rst = 0;
        set = new HashSet<>();
        // 逆序
        for (int i = n - 1; i >= 0; i--) {
            cur += nums[i];
            set.add(nums[i]);
            rst = sum - cur;
            if (cur == rst) {
                return true;
            } else if (cur > rst) {
                int need = (int) ((2 * cur - sum) / 2);
                if (set.contains(need)) {
                    return true;
                }
            } else {

            }
        }
        return false;
    }
}
