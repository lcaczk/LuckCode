package com.wkk.binarysearch;

/**
 * @author weikunkun
 * @since 2021/7/20
 */
public class LC_1095 {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        // 正常思路
        // 先寻找峰值点 k
        // 再在[0, k] 寻找或者 [k + 1, n - 1]寻找
        int n = mountainArr.length();
        int maxIdx = findMax(mountainArr);
        if (mountainArr.get(maxIdx) < target) {
            return -1;
        }
        int res = findValueLeft(mountainArr, target, 0, maxIdx);
        if (res != -1) {
            return res;
        }
        res = findValueRight(mountainArr, target, maxIdx + 1, n - 1);
        return res;
    }

    private int findMax(MountainArray mountainArr) {
        int n = mountainArr.length();
        int i = 0;
        int j = n - 1;
        while (i < j) {
            int mid = i + j >> 1;
            if (mountainArr.get(mid) < mountainArr.get(mid + 1)) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return i;
    }

    private int findValueLeft(MountainArray mountainArr, int target, int left, int right) {
        while (left < right) {
            int mid = left + right >> 1;
            if (mountainArr.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }

    private int findValueRight(MountainArray mountainArr, int target, int left, int right) {
        while (left < right) {
            int mid = left + right + 1 >> 1;
            if (mountainArr.get(mid) < target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return mountainArr.get(left) == target ? left : -1;
    }
}
