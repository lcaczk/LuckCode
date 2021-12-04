package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/6/13
 */
public class LC_278 {
    public static int firstBadVersion(int n) {
        int left = 1;
        int right = n;
        boolean low = isBadVersion(left);
        if (low) {
            return left;
        }
        while (left < right) {
            int mid = (left + right) / 2;
            if (!isBadVersion(mid)) {
                left = mid + 1;
            } else {
                right = left;
            }
        }
        return left;
    }

    private static boolean isBadVersion(int n) {
        return  n == 4;
    }

    public static void main(String[] args) {
        firstBadVersion(7);
    }
}
