package com.wkk.recursive;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author weikunkun
 * @since 2021/7/29
 */
public class LC_1104 {
    private List<Integer> res = new ArrayList<>();
    public List<Integer> pathInZigZagTree(int label) {
        int level = getCurLevel(label);
        res.add(label);
        recurtion(label, level);
        Collections.sort(res);
        return res;
    }

    private int getCurLevel(int label) {
        int level = 0;
        while (label >= 1) {
            level++;
            label /= 2;
        }
        return level;
    }

    private void recurtion(int label, int level) {
        if (label == 1) {
            return;
        }
        int half = label / 2;
        int preMin = (int)Math.pow(2, level - 2);
        int preMax = (int)Math.pow(2, level - 1) - 1;
        int sum = preMax + preMin;
        int root = sum - half;
        res.add(root);
        recurtion(root, level - 1);
    }

    public static void main(String[] args) {
        LC_1104 lc_1104 = new LC_1104();
        lc_1104.pathInZigZagTree(26);
        System.out.println(lc_1104.res);
    }
}
