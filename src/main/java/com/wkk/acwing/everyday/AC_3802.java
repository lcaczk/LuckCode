package com.wkk.acwing.everyday;

import java.util.Scanner;

/**
 * @author weikunkun
 * @since 2021/8/13
 */
public class AC_3802 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }

            System.out.println(nonDescending(nums, 0, n - 1));
        }
        scanner.close();
    }

    public static int nonDescending(int[] nums, int start, int end) {
        if (start == end) {
            return 1;
        }
        boolean flag = true;
        for (int i = start; i < end; i++) {
            if (nums[i] > nums[i + 1]) {
                flag = false;
                break;
            }
        }
        if (flag) {
            return end - start + 1;
        } else {
            // 如果它不是非降序的，那么就将它的前半部分或后半部分消灭
            int mid = start + (end - start) / 2;
            return Math.max(nonDescending(nums, start, mid), nonDescending(nums, mid + 1, end));
        }
    }
}
