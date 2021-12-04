package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/7/11
 */
public class LC_274 {
    public static int hIndex(int[] citations) {
        int n = citations.length;
        int i = 0;
        int j = n;
        while (i < j) {
            int mid = (i + j + 1) / 2;
            if (check(mid, citations)) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return i;
    }

    private static boolean check(int target, int[] citations) {
        int count = 0;
        for (int num : citations) {
            if (num >= target) {
                count++;
            }
        }
        return count < target;
    }

    public static int hIndexI(int[] cs) {
        int n = cs.length;
        int l = 0, r = n;
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(cs, mid)) l = mid;
            else r = mid - 1;
        }
        return r;
    }

    static boolean check(int[] cs, int mid) {
        int ans = 0;
        for (int i : cs) if (i >= mid) ans++;
        return ans >= mid;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 1};
        System.out.println(hIndex(arr));
    }
}
