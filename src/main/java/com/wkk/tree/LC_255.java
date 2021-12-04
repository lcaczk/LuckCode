package com.wkk.tree;

/**
 * @author weikunkun
 * @since 2021/7/31
 */
public class LC_255 {
    public boolean verifyPreorder(int[] preorder) {
        // 寻找拐点
        // 然后判断左边递减 右边递增
        int minIdx = getMin(preorder);
        int n = preorder.length;
        for (int i = 1; i < minIdx; i++) {
            if (preorder[i] > preorder[i - 1]) {
                return false;
            }
        }

        for (int i = minIdx + 1; i < n; i++) {
            if (preorder[i] < preorder[i - 1]) {
                return false;
            }
        }
        return true;
    }

    private int getMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        int minIdx = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static void main(String[] args) {
        LC_255 lc_255 = new LC_255();
        int[] arr = {1, 3, 2};
        lc_255.verifyPreorder(arr);
    }
}
